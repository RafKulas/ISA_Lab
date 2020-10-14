package pl.edu.eti.pg.lab.student.entity;

import lombok.*;
import pl.edu.eti.pg.lab.faculty.entity.Faculty;

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

	private int indexNumber;
}
