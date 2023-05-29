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

@NamedQueries({ @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
		@NamedQuery(name = "Course.findCodeByTitle", query = "SELECT c.code FROM Course c WHERE c.title = :title")

})

public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String code;

	@Column(unique = true, nullable = false)
	private String title;

	private String description;

	@OneToMany(mappedBy = "course")
	private List<CourseStudent> courseStudents = new ArrayList<>();

	// ins
	public Course(String title, String description) {
		this.title = title;
		this.description = description;
	}

	// up
	public Course(String code, String title, String description) {
		this.code = code;
		this.title = title;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Course [code=" + code + ", title=" + title + ", description=" + description + "]";
	}

}
