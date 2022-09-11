package pl.edu.eti.pg.lab.faculty.dto;

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
public class GetFacultiesResponse {

	List<Faculty> facultiesResponse;

	public static Function<Collection<pl.edu.eti.pg.lab.faculty.entity.Faculty>, GetFacultiesResponse> entityToDtoMapper() {
		return faculties -> {
			List<Faculty> facultiesResponse = new LinkedList<>();
			faculties.stream()
					.map(faculty ->
							new Faculty(faculty.getAmountOfStudents(), faculty.getName(),
									faculty.getDean()))
					.forEach(facultiesResponse::add);
			return new GetFacultiesResponse(facultiesResponse);
		};
	}

	private record Faculty(
			int numberOfStudents,
			String name,
			String dean) {
	}
}
