package pl.edu.eti.pg.lab.entity;

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

	private String name; //PK

	@ToString.Exclude
	private List<String> fieldsOfStudies;
}
