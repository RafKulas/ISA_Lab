package pl.edu.eti.pg.lab.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<E, K> {
	Optional<K> find(E primaryKey);

	List<K> findAll();

	void create(K entity);

	void delete(E primaryKey);

	void update(K entity);
}
