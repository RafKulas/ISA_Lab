package pl.edu.eti.pg.lab.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.eti.pg.lab.faculty.entity.Faculty;
import pl.edu.eti.pg.lab.student.entity.Student;
import pl.edu.eti.pg.lab.faculty.service.FacultyService;
import pl.edu.eti.pg.lab.student.services.StudentService;

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
		Faculty eti = new Faculty("ETI");
		Faculty oio = new Faculty("OIO");

		facultyService.create(eti);
		facultyService.create(oio);

		Student rafal = new Student(175750, "Rafal", "Kulik", eti, "Informatics");
		Student piotr = new Student(167342, "Piotr", "Kaczmarek", eti, "Informatics");
		Student marta = new Student(166654, "Marta", "Morska", oio, "Ocean Engineering");
		Student pawel = new Student(189991, "Pawel", "Oceaniczny", oio, "Transport and Logistics");
		Student zuzia = new Student(101010, "Zuzia", "Jeziorowska", oio, "Ocean Engineering");
		Student kamil = new Student(156789, "Kamil", "Kacprowicz", eti, "Data engineering");

		studentService.create(rafal);
		studentService.create(piotr);
		studentService.create(marta);
		studentService.create(pawel);
		studentService.create(zuzia);
		studentService.create(kamil);
	}
}
