package pl.edu.eti.pg.lab.faculty.event.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.edu.eti.pg.lab.faculty.entity.Faculty;

import java.util.function.Function;

@Getter
@Setter
@AllArgsConstructor
public class CreateFacultyRequest {
	String name;

	public static Function<Faculty, CreateFacultyRequest> entityToDtoMapper() {
		return entity -> new CreateFacultyRequest(entity.getName());
	}
}
