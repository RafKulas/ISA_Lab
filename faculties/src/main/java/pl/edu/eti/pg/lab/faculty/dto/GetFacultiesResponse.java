package pl.edu.eti.pg.lab.faculty.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.eti.pg.lab.faculty.entity.Faculty;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetFacultiesResponse {

	List<FacultyDto> facultiesResponse;

	public static Function<Collection<Faculty>, GetFacultiesResponse> entityToDtoMapper() {
		return faculties -> {
			List<FacultyDto> facultiesResponse = faculties.stream()
					.map(faculty ->
							new FacultyDto(
									faculty.getName(),
									faculty.getDean(),
									faculty.getAmountOfStudents()
							))
					.toList();
			return new GetFacultiesResponse(facultiesResponse);
		};
	}

	private record FacultyDto(
			String name,
			String dean,
			int numberOfStudents) {
	}
}
