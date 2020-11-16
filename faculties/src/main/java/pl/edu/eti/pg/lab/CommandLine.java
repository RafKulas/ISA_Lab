//package pl.edu.eti.pg.lab;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import pl.edu.eti.pg.lab.faculty.entity.Faculty;
//import pl.edu.eti.pg.lab.student.entity.Student;
//import pl.edu.eti.pg.lab.faculty.service.FacultyService;
//import pl.edu.eti.pg.lab.student.services.StudentService;
//
//import java.util.Optional;
//import java.util.Scanner;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Component
//public class CommandLine implements CommandLineRunner {
//
//	private final StudentService studentService;
//	private final FacultyService facultyService;
//	private final Scanner sc = new Scanner(System.in);
//
//	@Autowired
//	public CommandLine(StudentService studentService, FacultyService facultyService) {
//		this.studentService = studentService;
//		this.facultyService = facultyService;
//	}
//
//	@Override
//	public void run(String... args) {
//		boolean quit = false;
//		while (!quit) {
//			showMenu();
//			try {
//				int order = sc.nextInt();
//				quit = command(order);
//			}
//			catch (Exception e) {
//				System.out.println("Wrong order, try again...\n");
//				sc.next();
//			}
//		}
//
//	}
//
//	private void showMenu() {
//		System.out.println("Choose option:\n" +
//				"1) Add student to study\n" +
//				"2) Change student's faculty\n" +
//				"3) Remove a student from studies\n" +
//				"4) Show all students\n" +
//				"5) Show all faculties\n" +
//				"6) Show all field of studies\n" +
//				"0) Quit\n");
//	}
//
//	private boolean command(int order) throws Exception {
//		switch (order) {
//			case 1:
//				addStudent();
//				return false;
//			case 2:
//				changeStudentsFaculty();
//				return false;
//			case 3:
//				removeStudent();
//				return false;
//			case 4:
//				studentService.findAll().forEach(System.out::println);
//				return false;
//			case 5:
//				facultyService.findAll().forEach(System.out::println);
//				return false;
//			case 6:
//				Set<String> fieldsOfStudies = studentService
//						.findAll()
//						.stream()
//						.map(Student::getFieldOfStudies)
//						.collect(Collectors.toSet());
//				fieldsOfStudies.forEach(System.out::println);
//				return false;
//			default:
//				return true;
//		}
//	}
//
//	private Student createStudent() throws Exception{
//		System.out.println("Give name of new student:");
//		String name = sc.next();
//		System.out.println("Give surname of new student:");
//		String surname = sc.next();
//		System.out.println("What new student want to study?");
//		String fieldOfStudies = sc.next();
//		System.out.println("On which faculty?");
//		Optional<Faculty> faculty = facultyService.find(sc.next());
//		System.out.println("Set number of index:");
//		int index = sc.nextInt();
//		if (faculty.isEmpty()) {
//			throw new Exception();
//		}
//		return new Student(name, surname, faculty.get(), fieldOfStudies, index);
//	}
//
//	private void addStudent() throws Exception {
//		Student student = createStudent();
//		studentService.create(student);
//
//		System.out.printf("\nStudent %s added successfully!\n", student.toString());
//	}
//
//	private void changeStudentsFaculty() throws Exception {
//		System.out.println("Which student shall change faculty?");
//		int index = sc.nextInt();
//		Optional<Student> stu = studentService.find(index);
//		if (stu.isEmpty()) {
//			throw new Exception();
//		}
//		Student student = stu.get();
//		System.out.printf("Change %s to...\n", student.getFaculty().getName());
//		String facultyName = sc.next();
//		Optional<Faculty> fac = facultyService.find(facultyName);
//		if (fac.isEmpty()) {
//			throw new Exception();
//		}
//		student.setFaculty(fac.get());
//		studentService.update(student);
//
//		System.out.printf("\nStudent %s changed faculty successfully!\n", student.toString());
//	}
//
//	private void removeStudent(){
//		System.out.println("Give index number of student that should be removed from study");
//		int index = sc.nextInt();
//		studentService.find(index).ifPresent(studentService::delete);
//
//		System.out.printf("\nStudent (%d) removed successfully!\n", index);
//	}
//}
