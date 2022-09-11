package pl.edu.eti.pg.lab.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.edu.eti.pg.lab.faculty.entity.Faculty;
import pl.edu.eti.pg.lab.student.entity.Student;

import java.util.function.Function;

@Getter
@AllArgsConstructor
public class CreateStudentRequest {

	private String name;
	private String surname;
	private String faculty;
	private String fieldOfStudies;
	private int indexNumber;

	public static Function<CreateStudentRequest, Student> dtoToEntityMapper(
			Function<String, Faculty> facultyFunction
	) {
		return request -> new Student(
				request.getIndexNumber(),
				request.getName(),
				request.getSurname(),
				facultyFunction.apply(request.getFaculty()),
				request.getFieldOfStudies());
	}
}
