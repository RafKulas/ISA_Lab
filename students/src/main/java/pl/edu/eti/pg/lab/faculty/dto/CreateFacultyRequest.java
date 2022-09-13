package pl.edu.eti.pg.lab.faculty.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.eti.pg.lab.faculty.entity.Faculty;

import java.util.function.Function;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateFacultyRequest {
	private String name;

	public static Function<CreateFacultyRequest, Faculty> dtoToEntityMapper() {
		return request -> new Faculty(request.getName());
	}
}
