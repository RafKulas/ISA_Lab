package pl.edu.eti.pg.lab.entity;

import java.util.List;
import java.util.Objects;

public class Faculty {
	private int amountOfStudents;

	private String name; //PK

	private List<String> fieldsOfStudies;

	public Faculty(int amountOfStudents, String name, List<String> fieldsOfStudies) {
		this.amountOfStudents = amountOfStudents;
		this.name = name;
		this.fieldsOfStudies = fieldsOfStudies;
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

	public List<String> getFieldsOfStudies() {
		return fieldsOfStudies;
	}

	public void setFieldsOfStudies(List<String> fieldsOfStudies) {
		this.fieldsOfStudies = fieldsOfStudies;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amountOfStudents, name, fieldsOfStudies);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Faculty other = (Faculty) obj;
		return name.equals(other.name) && amountOfStudents == other.amountOfStudents && fieldsOfStudies.equals(other.fieldsOfStudies);
	}

	@Override
	public String toString() {
		return String.format("%s: %s", name, String.join(", ", fieldsOfStudies));
	}
}
