package pl.edu.eti.pg.lab.faculty.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.edu.eti.pg.lab.student.entity.Student;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "faculties")
public class Faculty implements Serializable {
	@Id
	@Column(name = "name")
	private String name;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "faculty")
	private List<Student> studentList;

	public Faculty(String name) {
		this.name = name;
	}
}
