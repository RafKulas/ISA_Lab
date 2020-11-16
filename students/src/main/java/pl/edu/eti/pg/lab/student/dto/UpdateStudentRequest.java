package pl.edu.eti.pg.lab.student.dto;

import pl.edu.eti.pg.lab.student.entity.Student;

import java.util.function.BiFunction;

public class UpdateStudentRequest {
	private String name;

	private String surname;

	private String fieldOfStudies;

	public static BiFunction<Student, UpdateStudentRequest, Student> dtoToEntityUpdater() {
		return (student, request) -> {
			student.setName(request.getName());
			student.setSurname(request.getSurname());
			student.setFieldOfStudies(request.getFieldOfStudies());
			return student;
		};
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getFieldOfStudies() {
		return fieldOfStudies;
	}
}
