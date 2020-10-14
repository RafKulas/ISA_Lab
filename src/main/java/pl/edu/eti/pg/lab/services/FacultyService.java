package pl.edu.eti.pg.lab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.eti.pg.lab.entity.Faculty;
import pl.edu.eti.pg.lab.repository.FacultyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
	private final FacultyRepository repository;

	@Autowired
	public FacultyService(FacultyRepository repository) {
		this.repository = repository;
	}

	public Optional<Faculty> find(String primaryKey) {
		return repository.find(primaryKey);
	}

	public List<Faculty> findAll() {
		return repository.findAll();
	}

	public void create(Faculty entity) {
		repository.create(entity);
	}

	public void delete(String primaryKey) {
		repository.delete(primaryKey);
	}

	public void update(Faculty entity) {
		repository.update(entity);
	}
}
