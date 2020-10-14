package pl.edu.eti.pg.lab.repository;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.eti.pg.lab.entity.Student;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class StudentRepository implements Repository<Integer, Student> {

	private final DataStore store;

	@Autowired
	public StudentRepository(DataStore store) {
		this.store = store;
	}

	@Override
	public Optional<Student> find(Integer primaryKey) {
		return store.findStudent(primaryKey);
	}

	@Override
	public List<Student> findAll() {
		return store.findAllStudents();
	}

	@Override
	public void create(Student entity) {
		store.updateStudent(entity);
	}

	@Override
	public void delete(Integer primaryKey) {
		store.removeStudent(primaryKey);
	}

	@Override
	public void update(Student entity) {
		store.updateStudent(entity);
	}
}
