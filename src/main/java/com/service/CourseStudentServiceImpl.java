package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Course;
import com.entity.Student;
import com.repository.CourseStudentRepository;

@Service
public class CourseStudentServiceImpl implements CourseStudentService {

	@Autowired
	private CourseStudentRepository csr;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Course> getAllCourses() {
		List<Course> courses = null;
		try {
			courses = csr.getAllCourses();
			log.info("lettura Courses avvenuta con successo!");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("lettura Courses fallita");
		}
		return courses;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = null;
		try {
			students = csr.getAllStudents();
			log.info("lettura Students avvenuta con successo!");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("lettura Students fallita");
		}
		return students;
	}

	@Override
	public List<Course> getAllCoursesByStudent(String email) {
		List<Course> courses = null;
		try {
			courses = csr.getAllCoursesByStudent(email);
			log.info("lettura Courses By Student avvenuta con successo!");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("lettura Courses By Student fallita");
		}
		return courses;
	}

	@Override
	public List<Student> getAllStudentsByCourse(String title) {
		List<Student> students = null;
		try {
			students = csr.getAllStudentsByCourse(title);
			log.info("lettura Students By Course avvenuta con successo!");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("lettura Students By Course fallita");
		}
		return students;
	}

	@Override
	public void createCourse(Course course) {
		try {
			csr.createCourse(course);
			log.info("creazione Course avvenuta con successo!");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("creazione Course fallita");
		}

	}

	@Override
	public void createStudent(Student student) {
		try {
			csr.createStudent(student);
			log.info("creazione Student avvenuta con successo!");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("creazione Student fallita");
		}

	}

	@Override
	public void createCourseWithStudents(Course course, List<Student> students) {
		try {
			csr.createCourseWithStudents(course, students);
			log.info("creazione Course With Students avvenuta con successo!");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("creazione Course With Students fallita");
		}
	}

	@Override
	public void createStudentWithCourses(Student student, List<Course> courses) {
		try {
			csr.createStudentWithCourses(student, courses);
			log.info("creazione Student With Course avvenuta con successo!");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("creazione Student With Course fallita");
		}
	}

	@Override
	public void updateStudent(Student student) {
		try {
			csr.updateStudent(student);
			log.info("aggiornamento Student avvenuta con successo!");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("aggiornamento Student fallita");
		}
	}

	@Override
	public void updateCourse(Course course) {
		try {
			csr.updateCourse(course);
			log.info("aggiornamento Course avvenuta con successo!");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("aggiornamento Course fallita");
		}
	}

	@Override
	public void updateCourseStudent(String title, String email) {
		try {
			csr.updateCourseStudent(title, email);
			log.info("aggiornamento CourseStudent avvenuta con successo!");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("aggiornamento CourseStudent fallita");
		}
	}

	@Override
	public void updateCourseStudentRM(String title, String email) {
		try {
			csr.updateCourseStudentRM(title, email);
			log.info("aggiornamento CourseStudent in rimozione avvenuta con successo!");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("aggiornamento CourseStudent in rimozione fallita");
		}
	}

	@Override
	public void deleteCourse(String code) {
		try {
			csr.deleteCourse(code);
			log.info("rimozione Course avvenuta con successo!");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("rimozione Course fallita");
		}
	}

	@Override
	public void deleteStudent(String passportNumber) {
		try {
			csr.deleteStudent(passportNumber);
			log.info("rimozione Student avvenuta con successo!");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("rimozione Student fallita");
		}
	}

	@Override
	public String readCourseCodeByTitle(String title) {
		return null;
	}

	@Override
	public String readStudentPNByEmail(String email) {
		return null;
	}

}
