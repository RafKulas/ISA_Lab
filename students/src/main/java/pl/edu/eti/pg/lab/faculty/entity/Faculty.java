package pl.edu.eti.pg.lab.faculty.entity;

import pl.edu.eti.pg.lab.student.entity.Student;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "faculties")
public class Faculty implements Serializable {
	@Id
	private String name; //PK

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "faculty")
	private List<Student> studentList;

	public Faculty(String name) {
		this.name = name;
	}

	public Faculty() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Faculty other = (Faculty) obj;
		return name.equals(other.name);
	}

	@Override
	public String toString() {
		return name;
	}
}
