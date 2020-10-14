package pl.edu.eti.pg.lab.faculty.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Faculty {
	private int amountOfStudents;

	private String name;

	@ToString.Exclude
	private List<String> fieldsOfStudies;
}
