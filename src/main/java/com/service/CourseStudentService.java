package com.service;

import java.util.List;

import com.entity.Course;
import com.entity.Student;

public interface CourseStudentService {

	public List<Course> getAllCourses();

	public List<Student> getAllStudents();

	public List<Course> getAllCoursesByStudent(String email);

	public List<Student> getAllStudentsByCourse(String title);

	public void createCourse(Course course);

	public void createStudent(Student student);

	public void createCourseWithStudents(Course course, List<Student> students);

	public void createStudentWithCourses(Student student, List<Course> courses);

	public void updateStudent(Student student);

	public void updateCourse(Course course);

	public void updateCourseStudent(String title, String email);

	public void updateCourseStudentRM(String title, String email);

	public void deleteCourse(String code);

	public void deleteStudent(String passportNumber);

	public String readCourseCodeByTitle(String title);

	public String readStudentPNByEmail(String email);
}
