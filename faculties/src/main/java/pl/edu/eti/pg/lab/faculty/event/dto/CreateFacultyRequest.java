package pl.edu.eti.pg.lab.faculty.event.dto;

import pl.edu.eti.pg.lab.faculty.entity.Faculty;

import java.util.function.Function;

public class CreateFacultyRequest {
	String name;

	public CreateFacultyRequest() {
	}

	public CreateFacultyRequest(String name) {
		this.name = name;
	}

	public static Function<Faculty, CreateFacultyRequest> entityToDtoMapper() {
		return entity -> new CreateFacultyRequest(entity.getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
