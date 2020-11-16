package pl.edu.eti.pg.lab.faculty.dto;

import pl.edu.eti.pg.lab.faculty.entity.Faculty;

import java.util.function.Function;

public class CreateFacultyRequest {
	private String name;

	public static Function<CreateFacultyRequest, Faculty> dtoToEntityMapper() {
		return request -> new Faculty(request.getName());
	}

	public CreateFacultyRequest(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
