package com.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity

@NamedQueries({ @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
		@NamedQuery(name = "Student.findPNByEmail", query = "SELECT s.passportNumber FROM Student s WHERE s.email = :email") })

public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "passport_number")
	private String passportNumber;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private Integer age;

	@OneToMany(mappedBy = "student")
	private List<CourseStudent> courseStudents = new ArrayList<>();

	// ins
	public Student(String email, String firstName, String lastName, Integer age) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public Student(String passportNumber, String email, String firstName, String lastName, Integer age) {
		this.passportNumber = passportNumber;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [passportNumber=" + passportNumber + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", age=" + age + "]";
	}

}
