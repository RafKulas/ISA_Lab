package pl.edu.eti.pg.lab.datastore;

import org.springframework.stereotype.Component;
import pl.edu.eti.pg.lab.faculty.entity.Faculty;
import pl.edu.eti.pg.lab.student.entity.Student;

import java.util.*;

@Component
class DataStore {
	private final Set<Faculty> faculties = new HashSet<>();
	private final Set<Student> students = new HashSet<>();

	public synchronized List<Faculty> findAllFaculties() {
		return new LinkedList<>(faculties);
	}

	public synchronized Optional<Faculty> findFaculty(String name) {
		return faculties.stream()
				.filter(faculty -> faculty.getName().equals(name))
				.findFirst();
	}

	public synchronized Optional<Faculty> findByDean(String dean) {
		return faculties.stream().filter(f -> f.getDean().equals(dean)).findFirst();
	}

	public synchronized void createFaculty(Faculty faculty) {
		findFaculty(faculty.getName()).ifPresentOrElse(
				original -> {
					throw new IllegalArgumentException(
							String.format("Faculty named \"%s\" already exists", faculty.getName()));
				},
				() -> faculties.add(faculty)
		);
	}

	public synchronized void removeFaculty(String name) {
		findFaculty(name).ifPresentOrElse(
				faculties::remove,
				() -> {
					throw new IllegalArgumentException(
							String.format("Faculty called \"%s\" doesn't exist.", name));
				});
	}

	public synchronized void updateFaculty(Faculty faculty) {
		findFaculty(faculty.getName()).ifPresentOrElse(
				original -> {
					faculties.remove(original);
					faculties.add(faculty);
				},
				() -> {
					throw new IllegalArgumentException(
							String.format("Faculty called \"%s\" doesn't exist.", faculty.getName()));
				});
	}

	public synchronized List<Student> findAllStudents() {
		return new LinkedList<>(students);
	}

	public synchronized Optional<Student> findStudent(int indexNumber) {
		return students.stream()
				.filter(student -> student.getIndexNumber()==indexNumber)
				.findFirst();
	}

	public synchronized void addStudent(Student student) {
		findStudent(student.getIndexNumber()).ifPresentOrElse(
				original -> {
					throw new IllegalArgumentException(
							String.format("Student with index \"%d\" already exists", student.getIndexNumber()));
				},
				() -> students.add(student)
		);
	}

	public synchronized void removeStudent(int indexNumber) {
		findStudent(indexNumber).ifPresentOrElse(
				students::remove,
				() -> {
					throw new IllegalArgumentException(
							String.format("Student with index \"%d\" doesn't exist.", indexNumber));
				});
	}

	public synchronized void updateStudent(Student student) {
		findStudent(student.getIndexNumber()).ifPresentOrElse(
				original -> {
					students.remove(original);
					students.add(student);
				},
				() -> {
					throw new IllegalArgumentException(
							String.format("Student with index \"%d\" doesn't exist.", student.getIndexNumber()));
				});
	}
}
