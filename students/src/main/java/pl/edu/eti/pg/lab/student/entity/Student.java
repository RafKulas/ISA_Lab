package pl.edu.eti.pg.lab.student.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.edu.eti.pg.lab.faculty.entity.Faculty;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "students")
public class Student implements Serializable {
	@Id
	private int indexNumber; //PK

	private String name;

	private String surname;

	@ManyToOne
	@JoinColumn(name = "faculty")
	private Faculty faculty;

	private String fieldOfStudies;
}
