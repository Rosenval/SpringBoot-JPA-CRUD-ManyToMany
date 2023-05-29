package com;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.entity.Course;
import com.entity.CourseStudent;
import com.entity.CourseStudentPK;
import com.entity.Student;

@Configuration
public class BeanConfig {

	@Bean(name = "createCourse")
	public Course createCourse() {
		return new Course("computer science", "scrittura di roba colorata in uno schermo");
	}

	@Bean(name = "createCourse1")
	public Course createCourse1() {
		return new Course("philosopy", "domande senza risposte");
	}

	@Bean(name = "createCourse2")
	public Course createCourse2() {
		return new Course("medicine", "a na certa forse ti laurei");
	}

	@Bean(name = "createCourseList")
	public List<Course> createCourseList() {
		return new ArrayList<Course>();
	}

	@Bean(name = "createCourseStudentPK")
	public CourseStudentPK createCourseStudentPK() {
		return new CourseStudentPK();
	}

	@Bean(name = "createCourseStudent")
	public CourseStudent createCourseStudent() {
		return new CourseStudent();
	}

	/*********************************************/
	@Bean(name = "createStudent")
	public Student createStudent() {
		return new Student("mia@queen.com", "Mia", "Queen", 26);
	}

	@Bean(name = "createStudent1")
	public Student createStudent1() {
		return new Student("freddy@king.com", "Freddy", "Maniskalhk", 21);
	}

	@Bean(name = "createStudent2")
	public Student createStudent2() {
		return new Student("michael@king.com", "Michael", "Circle", 26);
	}

	@Bean(name = "createStudent3")
	public Student createStudent3() {
		return new Student("julio@king.com", "Julio", "Grimaniz", 26);
	}

	@Bean(name = "createStudentList")
	public List<Student> createStudentList() {
		return new ArrayList<Student>();
	}
}
