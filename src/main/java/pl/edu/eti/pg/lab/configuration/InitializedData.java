package pl.edu.eti.pg.lab.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.eti.pg.lab.entity.Faculty;
import pl.edu.eti.pg.lab.services.FacultyService;
import pl.edu.eti.pg.lab.services.StudentService;

import javax.annotation.PostConstruct;

@Component
public class InitializedData {

	private final StudentService studentService;
	private final FacultyService facultyService;

	@Autowired
	public InitializedData(StudentService studentService, FacultyService facultyService) {
		this.studentService = studentService;
		this.facultyService = facultyService;
	}

	@PostConstruct
	public void initializeData() {
	}
}
