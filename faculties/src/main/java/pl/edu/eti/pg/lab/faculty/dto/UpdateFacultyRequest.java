package pl.edu.eti.pg.lab.faculty.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.edu.eti.pg.lab.faculty.entity.Faculty;

import java.util.function.BiFunction;

@Getter
@Setter
@AllArgsConstructor
public class UpdateFacultyRequest {

	private String name;
	private String dean;
	private int numberOfStudents;

	public static BiFunction<Faculty, UpdateFacultyRequest, Faculty> dtoToEntityUpdater() {
		return (faculty, request) -> {
			faculty.setName(request.getName());
			faculty.setDean(request.getDean());
			faculty.setAmountOfStudents(request.getNumberOfStudents());
			return faculty;
		};
	}
}
