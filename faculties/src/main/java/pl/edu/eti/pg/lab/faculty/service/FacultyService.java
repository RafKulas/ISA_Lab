package pl.edu.eti.pg.lab.faculty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.eti.pg.lab.faculty.entity.Faculty;
import pl.edu.eti.pg.lab.faculty.event.repository.FacultyEventRepository;
import pl.edu.eti.pg.lab.faculty.repository.FacultyRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
	private final FacultyRepository repository;
	private final FacultyEventRepository eventRepository;

	@Autowired
	public FacultyService(FacultyRepository repository, FacultyEventRepository eventRepository) {
		this.repository = repository;
		this.eventRepository = eventRepository;
	}

	public Optional<Faculty> find(String primaryKey) {
		return repository.findById(primaryKey);
	}

	public Optional<Faculty> findByDean(String dean) {
		return repository.findByDean(dean);
	}

	public List<Faculty> findAll() {
		return repository.findAll();
	}

	@Transactional
	public void delete(Faculty entity) {
		repository.delete(entity);
		eventRepository.delete(entity);
	}

	@Transactional
	public void create(Faculty entity) {
		repository.save(entity);
		//eventRepository.create(entity);
	}

	@Transactional
	public void update(Faculty entity) {
		repository.save(entity);
	}
}
