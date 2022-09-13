package pl.edu.eti.pg.lab.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.edu.eti.pg.lab.student.entity.Student;

import java.util.function.Function;

@Getter
@Setter
@AllArgsConstructor
public class GetStudentResponse {
	private String name;
	private String surname;
	private String faculty;
	private String fieldOfStudies;
	private int indexNumber;

	public static Function<Student, GetStudentResponse> entityToDtoMapper() {
		return request -> new GetStudentResponse(
				request.getName(),
				request.getSurname(),
				request.getFaculty().getName(),
				request.getFieldOfStudies(),
				request.getIndexNumber()
		);
	}
}
