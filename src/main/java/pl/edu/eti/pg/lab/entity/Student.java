package pl.edu.eti.pg.lab.entity;

import java.util.Objects;

public class Student {
	private String name;

	private String surname;

	private Faculty faculty;

	private String fieldOfStudies;

	private int indexNumber; //PK

	public Student(String name, String surname, Faculty faculty, String fieldOfStudies, int indexNumber) {
		this.name = name;
		this.surname = surname;
		this.faculty = faculty;
		this.fieldOfStudies = fieldOfStudies;
		this.indexNumber = indexNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public String getFieldOfStudies() {
		return fieldOfStudies;
	}

	public void setFieldOfStudies(String fieldOfStudies) {
		this.fieldOfStudies = fieldOfStudies;
	}

	public int getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(int indexNumber) {
		this.indexNumber = indexNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, surname, indexNumber, faculty, fieldOfStudies);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Student other = (Student) obj;
		return name.equals(other.name) && surname.equals(other.surname) && indexNumber==other.indexNumber
				&& fieldOfStudies.equals(other.fieldOfStudies) && faculty.equals(other.faculty);
	}

	@Override
	public String toString() {
		return String.format("%s %20s %d - %s (%s)", name, surname, indexNumber, fieldOfStudies, faculty.getName());
	}
}
