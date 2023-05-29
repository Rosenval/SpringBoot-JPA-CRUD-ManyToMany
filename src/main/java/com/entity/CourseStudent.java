package com.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "course_student")
public class CourseStudent {
	@EmbeddedId
	private CourseStudentPK courseStudentPK;

	// @MapsId("code") indica che il campo course mappa la colonna code nella
	// tabella di collegamento
	// ergo, il valore di code nell'oggetto CourseStudent corrisponde al valore
	// della
	// chiave primaria code nella tabella di collegamento
	// (ovviamente stessa cosa vale per student)

	@ManyToOne
	@MapsId("code")
	@JoinColumn(name = "code")
	private Course course;

	@ManyToOne
	@MapsId("passportNumber")
	@JoinColumn(name = "passport_number")
	private Student student;

	@Override
	public String toString() {
		return "CourseStudent [course=" + course + ", student=" + student + "]";
	}

}
