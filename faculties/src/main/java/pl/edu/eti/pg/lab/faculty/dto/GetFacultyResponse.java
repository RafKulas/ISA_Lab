package pl.edu.eti.pg.lab.faculty.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.edu.eti.pg.lab.faculty.entity.Faculty;

import java.util.function.Function;

@Getter
@Setter
@AllArgsConstructor
public class GetFacultyResponse {

	private String dean;
	private String name;
	private int numberOfStudents;

	public static Function<Faculty, GetFacultyResponse> entityToDtoMapper() {
		return request ->
				new GetFacultyResponse(request.getDean(), request.getName(),
						request.getAmountOfStudents());
	}
}
