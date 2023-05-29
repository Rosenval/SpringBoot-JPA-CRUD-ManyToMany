package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.Course;
import com.entity.Student;
import com.service.CourseStudentService;

import jakarta.annotation.Resource;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CourseStudentService css;

	@Resource(name = "createCourse")
	public Course createCourse;

	@Resource(name = "createCourse1")
	public Course createCourse1;

	@Resource(name = "createCourse2")
	public Course createCourse2;

	@Resource(name = "createCourseList")
	public List<Course> createCourseList;

	/************************************************/

	@Resource(name = "createStudent")
	public Student createStudent;

	@Resource(name = "createStudent1")
	public Student createStudent1;

	@Resource(name = "createStudent2")
	public Student createStudent2;

	@Resource(name = "createStudent3")
	public Student createStudent3;

	@Resource(name = "createStudentList")
	public List<Student> createStudentList;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		createStudentList.add(createStudent);
		createStudentList.add(createStudent1);
		css.createCourseWithStudents(createCourse, createStudentList);

		createCourseList.add(createCourse1);
		createCourseList.add(createCourse2);
		css.createStudentWithCourses(createStudent2, createCourseList);

//		css.deleteCourse("computer science");
//		css.deleteStudent("mia@queen.com");

//		css.getAllCoursesByStudent("mia@queen.com").forEach(System.out::println);
//		css.getAllStudentsByCourse("computer science").forEach(System.out::println);

//		css.createStudent(createStudent3);
//		css.deleteStudent("julio@king.com");

//		createStudent3.setEmail("giulia@furry.com");
//		css.updateStudent(createStudent3);

//		css.updateCourseStudent("computer science", "julio@king.com");
//		css.updateCourseStudentRM("computer science", "mia@queen.com");

	}

}
