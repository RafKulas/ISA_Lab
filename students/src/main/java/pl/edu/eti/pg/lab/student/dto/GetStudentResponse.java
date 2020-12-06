package pl.edu.eti.pg.lab.student.dto;

import pl.edu.eti.pg.lab.student.entity.Student;

import java.util.function.Function;

public class GetStudentResponse {
	private String name;

	private String surname;

	private String faculty;

	private String fieldOfStudies;

	private int indexNumber;

	public static Function<Student, GetStudentResponse> entityToDtoMapper() {
		return request ->
				new GetStudentResponse(request.getName(), request.getSurname(),
						request.getFaculty().getName(), request.getFieldOfStudies(), request.getIndexNumber());
	}

	public GetStudentResponse(String name, String surname, String faculty, String fieldOfStudies, int indexNumber) {
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

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
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
}
