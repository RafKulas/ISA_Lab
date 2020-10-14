package pl.edu.eti.pg.lab.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.edu.eti.pg.lab.services.StudentService;

@Component
public class CommandLine implements CommandLineRunner {

	private final StudentService studentService;

	@Autowired
	public CommandLine(StudentService studentService) {
		this.studentService = studentService;
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
