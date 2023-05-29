package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

//annotazione che indica che le istanze di questa classe possono essere
//incorporate all'interno di altre entità come chiave primaria composta
@Embeddable
public class CourseStudentPK {

	@Column(name = "code")
	private String code;

	@Column(name = "passport_number")
	private String passportNumber;

}
