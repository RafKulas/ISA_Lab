package pl.edu.eti.pg.lab.entity;

import java.util.List;

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
}
