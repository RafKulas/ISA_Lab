package pl.edu.eti.pg.lab.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Student {
	private String name;

	private String surname;

	private Faculty faculty;

	private String fieldOfStudies;

	private int indexNumber; //PK
}
