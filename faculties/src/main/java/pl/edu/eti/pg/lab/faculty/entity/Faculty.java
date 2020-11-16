package pl.edu.eti.pg.lab.faculty.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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

	public Faculty(int amountOfStudents, String name, String dean) {
		this.amountOfStudents = amountOfStudents;
		this.name = name;
		this.dean = dean;
	}

	public Faculty() {

	}

	public int getAmountOfStudents() {
		return amountOfStudents;
	}

	public void setAmountOfStudents(int amountOfStudents) {
		this.amountOfStudents = amountOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDean() {
		return dean;
	}

	public void setDean(String dean) {
		this.dean = dean;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amountOfStudents, name, dean);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Faculty other = (Faculty) obj;
		return name.equals(other.name) && amountOfStudents == other.amountOfStudents && dean.equals(other.dean);
	}

	@Override
	public String toString() {
		return String.format("%s, %s: %d", name, dean, amountOfStudents);
	}
}
