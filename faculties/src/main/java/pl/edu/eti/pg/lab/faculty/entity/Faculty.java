package pl.edu.eti.pg.lab.faculty.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "faculties")
public class Faculty implements Serializable {
	private int amountOfStudents;

	@Id
	private String name;

	@Column(unique = true)
	private String dean;

//	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "faculty")
//	private List<Student> studentList;
}
