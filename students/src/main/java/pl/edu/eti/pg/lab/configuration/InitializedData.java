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

		Student rafal = new Student("Rafal", "Kulik", eti, "Informatics", 175750);
		Student piotr = new Student("Piotr", "Kaczmarek", eti, "Informatics", 167342);
		Student marta = new Student("Marta", "Morska", oio, "Ocean Engineering", 166654);
		Student pawel = new Student("Pawel", "Oceaniczny", oio, "Transport and Logistics", 189991);
		Student zuzia = new Student("Zuzia", "Jeziorowska", oio, "Ocean Engineering", 101010);
		Student kamil = new Student("Kamil", "Kacprowicz", eti, "Data engineering", 156789);

		studentService.create(rafal);
		studentService.create(piotr);
		studentService.create(marta);
		studentService.create(pawel);
		studentService.create(zuzia);
		studentService.create(kamil);
	}
}
