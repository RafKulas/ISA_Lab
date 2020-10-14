package pl.edu.eti.pg.lab.repository;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.eti.pg.lab.entity.Faculty;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class FacultyRepository implements Repository<String, Faculty> {

	private final DataStore store;

	@Autowired
	public FacultyRepository(DataStore store) {
		this.store = store;
	}

	@Override
	public Optional<Faculty> find(String primaryKey) {
		return store.findFaculty(primaryKey);
	}

	@Override
	public List<Faculty> findAll() {
		return store.findAllFaculties();
	}

	@Override
	public void create(Faculty entity) {
		store.createFaculty(entity);
	}

	@Override
	public void delete(String primaryKey) {
		store.removeFaculty(primaryKey);
	}

	@Override
	public void update(Faculty entity) {
		store.updateFaculty(entity);
	}
}
