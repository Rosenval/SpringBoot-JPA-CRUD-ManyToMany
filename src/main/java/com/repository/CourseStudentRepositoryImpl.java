package com.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Course;
import com.entity.CourseStudent;
import com.entity.CourseStudentPK;
import com.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Transactional
@Repository
public class CourseStudentRepositoryImpl implements CourseStudentRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Course> getAllCourses() {
		return em.createNamedQuery("Course.findAll", Course.class).getResultList();
	}

	@Override
	public List<Student> getAllStudents() {
		return em.createNamedQuery("Student.findAll", Student.class).getResultList();
	}

	@Override
	public List<Course> getAllCoursesByStudent(String email) {
		String query = "SELECT cs.course FROM CourseStudent cs where cs.student.email = :email";
		List<Course> courses = em.createQuery(query, Course.class).setParameter("email", email).getResultList();
		return courses;
	}

	@Override
	public List<Student> getAllStudentsByCourse(String title) {
		String query = "SELECT cs.student FROM CourseStudent cs where cs.course.title = :title";
		List<Student> students = em.createQuery(query, Student.class).setParameter("title", title).getResultList();
		return students;
	}

	@Override
	public void createCourse(Course course) {
		em.persist(course);
	}

	@Override
	public void createStudent(Student student) {
		em.persist(student);
	}

//	@Autowired
//	CourseStudentPK courseStudentPK;
//	@Autowired
//	CourseStudent courseStudent;
//
//	@Override
//	public void createCourseWithStudents(Course course, List<Student> students) {
//		em.persist(course);
//		for (Student s : students) {
//			em.persist(s);
//			courseStudentPK.setCode(course.getCode());
//			courseStudentPK.setPassportNumber(s.getPassportNumber());
//
//			courseStudent.setCourseStudentPK(courseStudentPK);
//			courseStudent.setCourse(course);
//			courseStudent.setStudent(s);
//			em.persist(courseStudent);
//		}
//	}

	@Override
	public void createCourseWithStudents(Course course, List<Student> students) {
		em.persist(course);
		for (Student s : students) {
			em.persist(s);
			CourseStudentPK courseStudentPK = new CourseStudentPK(course.getCode(), s.getPassportNumber());
			CourseStudent courseStudent = new CourseStudent(courseStudentPK, course, s);
			em.persist(courseStudent);
		}
	}

	@Override
	public void createStudentWithCourses(Student student, List<Course> courses) {
		em.persist(student);
		for (Course c : courses) {
			em.persist(c);
			CourseStudentPK courseStudentPK = new CourseStudentPK(c.getCode(), student.getPassportNumber());
			CourseStudent courseStudent = new CourseStudent(courseStudentPK, c, student);
			em.persist(courseStudent);
		}
	}

	@Override
	public void updateStudent(Student student) {
		em.merge(student);
	}

	@Override
	public void updateCourse(Course course) {
		em.merge(course);
	}

	// aggiunta corso/studente (quindi esistenti)
	@Override
	public void updateCourseStudent(String title, String email) {
		Course course = em.find(Course.class, readCourseCodeByTitle(title));
		Student student = em.find(Student.class, readStudentPNByEmail(email));
		CourseStudentPK courseStudentPK = new CourseStudentPK(course.getCode(), student.getPassportNumber());
		CourseStudent courseStudent = new CourseStudent(courseStudentPK, course, student);
		em.persist(courseStudent);
	}

	// rimozione studente da un corso
	// quindi studente continua ad esistere
	@Override
	public void updateCourseStudentRM(String title, String email) {
		Course course = em.find(Course.class, readCourseCodeByTitle(title));
		Student student = em.find(Student.class, readStudentPNByEmail(email));
		CourseStudentPK courseStudentPK = new CourseStudentPK(course.getCode(), student.getPassportNumber());
		em.remove(em.find(CourseStudent.class, courseStudentPK));
	}

	@Override
	public void deleteCourse(String title) {
		String courseCode = readCourseCodeByTitle(title);
		Course course = em.find(Course.class, courseCode);
		for (CourseStudent cs : course.getCourseStudents()) {
			em.remove(em.find(CourseStudent.class,
					new CourseStudentPK(course.getCode(), cs.getStudent().getPassportNumber())));
		}
		em.remove(course);
	}

	@Override
	public void deleteStudent(String email) {
		String studentPN = readStudentPNByEmail(email);
		Student student = em.find(Student.class, studentPN);
		for (CourseStudent cs : student.getCourseStudents()) {
			em.remove(em.find(CourseStudent.class,
					new CourseStudentPK(student.getPassportNumber(), cs.getCourse().getCode())));
		}
		em.remove(student);
	}

	@Override
	public String readCourseCodeByTitle(String title) {
		return em.createNamedQuery("Course.findCodeByTitle", String.class).setParameter("title", title)
				.getSingleResult();
	}

	@Override
	public String readStudentPNByEmail(String email) {
		return em.createNamedQuery("Student.findPNByEmail", String.class).setParameter("email", email)
				.getSingleResult();
	}
}
