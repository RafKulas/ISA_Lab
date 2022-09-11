package pl.edu.eti.pg.lab.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@AllArgsConstructor
public class GetStudentsResponse {

	private List<Student> studentsResponse;

	public static Function<Collection<pl.edu.eti.pg.lab.student.entity.Student>, GetStudentsResponse> entityToDtoMapper() {
		return students -> {
			List<Student> studentsResponse = new LinkedList<>();
			students.stream()
					.map(student ->
							new Student(student.getIndexNumber(), student.getName(),
									student.getSurname()))
					.forEach(studentsResponse::add);
			return new GetStudentsResponse(studentsResponse);
		};
	}

	private record Student(
			int indexNumber,
			String name,
			String surname
	) {
	}
}
