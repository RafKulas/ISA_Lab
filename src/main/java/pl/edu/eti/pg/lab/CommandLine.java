package pl.edu.eti.pg.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.edu.eti.pg.lab.entity.Faculty;
import pl.edu.eti.pg.lab.entity.Student;
import pl.edu.eti.pg.lab.services.FacultyService;
import pl.edu.eti.pg.lab.services.StudentService;

import java.util.Optional;
import java.util.Scanner;

@Component
public class CommandLine implements CommandLineRunner {

	private final StudentService studentService;
	private final FacultyService facultyService;
	private final Scanner sc = new Scanner(System.in);

	@Autowired
	public CommandLine(StudentService studentService, FacultyService facultyService) {
		this.studentService = studentService;
		this.facultyService = facultyService;
	}

	@Override
	public void run(String... args) {
		boolean quit = false;
		while (!quit) {
			showMenu();
			try {
				int order = sc.nextInt();
				quit = command(order);
			}
			catch (Exception e) {
				System.out.println("Wrong order, try again...\n");
				sc.next();
			}
		}

	}

	private void showMenu() {
		System.out.println("Choose option:\n" +
				"1) Add student to study\n" +
				"2) Change student's faculty\n" +
				"3) Remove a student from studies\n" +
				"4) Show all students\n" +
				"5) Show all faculties\n" +
				"6) Show all field of studies\n" +
				"0) Quit\n");
	}

	private boolean command(int order) throws Exception {
		switch (order) {
			case 1:
				addStudent();
				System.out.println("Student added successfully!");
				return false;
			case 2:
				changeStudentsFaculty();
				System.out.println("Student changed faculty successfully!");
				return false;
			case 3:
				removeStudent();
				System.out.println("Student removed successfully!");
				return false;
			case 4:
				studentService.findAll().forEach(System.out::println);
				return false;
			case 5:
				facultyService.findAll().forEach(System.out::println);
				return false;
			case 6:
				facultyService.findAll().forEach(f -> f.getFieldsOfStudies().forEach(System.out::println));
				return false;
			default:
				return true;
		}
	}

	private Student createStudent() throws Exception{
		System.out.println("Give name of new student:");
		String name = sc.next();
		System.out.println("Give surname of new student:");
		String surname = sc.next();
		System.out.println("What new student want to study?");
		String fieldOfStudies = sc.next();
		System.out.println("On which faculty?");
		Optional<Faculty> faculty = facultyService.find(sc.next());
		System.out.println("Set number of index:");
		int index = sc.nextInt();
		if (faculty.isEmpty()) {
			throw new Exception();
		}
		return new Student(name, surname, faculty.get(), fieldOfStudies, index);
	}

	private void addStudent() throws Exception {
		Student student = createStudent();
		studentService.create(student);
	}

	private void changeStudentsFaculty() throws Exception {
		System.out.println("Which student shall change faculty?");
		int index = sc.nextInt();
		Optional<Student> stu = studentService.find(index);
		if (stu.isEmpty()) {
			throw new Exception();
		}
		Student student = stu.get();
		System.out.printf("Change %s to...\n", student.getFieldOfStudies());
		String facultyName = sc.next();
		Optional<Faculty> fac = facultyService.find(facultyName);
		if (fac.isEmpty()) {
			throw new Exception();
		}
		student.setFaculty(fac.get());
		studentService.update(student);
	}

	private void removeStudent(){
		System.out.println("Give index number of student that should be removed from study");
		int index = sc.nextInt();
		studentService.delete(index);
	}
}
