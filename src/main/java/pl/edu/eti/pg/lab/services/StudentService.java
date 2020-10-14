package pl.edu.eti.pg.lab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.eti.pg.lab.entity.Student;
import pl.edu.eti.pg.lab.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
	private final StudentRepository repository;

	@Autowired
	public StudentService(StudentRepository repository) {
		this.repository = repository;
	}

	public Optional<Student> find(Integer primaryKey) {
		return repository.find(primaryKey);
	}

	public List<Student> findAll() {
		return repository.findAll();
	}

	public void create(Student entity) {
		repository.create(entity);
	}

	public void delete(Integer primaryKey) {
		repository.delete(primaryKey);
	}

	public void update(Student entity) {
		repository.update(entity);
	}
}
