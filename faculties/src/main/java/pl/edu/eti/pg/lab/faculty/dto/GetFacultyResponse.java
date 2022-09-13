package pl.edu.eti.pg.lab.faculty.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.eti.pg.lab.faculty.entity.Faculty;

import java.util.function.Function;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetFacultyResponse {

	private String name;
	private String dean;
	private int numberOfStudents;

	public static Function<Faculty, GetFacultyResponse> entityToDtoMapper() {
		return request -> new GetFacultyResponse(
				request.getName(),
				request.getDean(),
				request.getAmountOfStudents()
		);
	}
}
