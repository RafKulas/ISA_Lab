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
	@Column(name = "index_number")
	private int indexNumber; //PK

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@ManyToOne
	@JoinColumn(name = "faculty")
	private Faculty faculty;

	@Column(name = "field_of_studies")
	private String fieldOfStudies;
}
