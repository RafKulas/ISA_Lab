package pl.edu.eti.pg.lab.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.eti.pg.lab.faculty.entity.Faculty;
import pl.edu.eti.pg.lab.faculty.service.FacultyService;

import javax.annotation.PostConstruct;

@Component
public class InitializedData {

	private final FacultyService facultyService;

	@Autowired
	public InitializedData(FacultyService facultyService) {
		this.facultyService = facultyService;
	}

	@PostConstruct
	public void initializeData() {
		Faculty eti = new Faculty(300, "ETI", "prof. dr hab. inż. Jacek Stefański");
		Faculty oio = new Faculty(200, "OIO", "dr hab. inż. Wojciech Litwin");

		facultyService.create(eti);
		facultyService.create(oio);
	}
}
