package pl.edu.eti.pg.lab.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.edu.eti.pg.lab.student.entity.Student;

import java.util.function.BiFunction;

@Getter
@AllArgsConstructor
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
}
