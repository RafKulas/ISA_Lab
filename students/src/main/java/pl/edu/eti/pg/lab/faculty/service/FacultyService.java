package pl.edu.eti.pg.lab.faculty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.eti.pg.lab.faculty.entity.Faculty;
import pl.edu.eti.pg.lab.faculty.repository.FacultyRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FacultyService {
	private final FacultyRepository repository;

	@Autowired
	public FacultyService(FacultyRepository repository) {
		this.repository = repository;
	}

	public Optional<Faculty> find(String primaryKey) {
		return repository.findById(primaryKey);
	}

	@Transactional
	public void delete(Faculty entity) {
		repository.delete(entity);
	}

	@Transactional
	public Faculty create(Faculty entity) {
		return repository.save(entity);
	}
}
