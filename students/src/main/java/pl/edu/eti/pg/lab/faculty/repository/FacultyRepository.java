package pl.edu.eti.pg.lab.faculty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.eti.pg.lab.faculty.entity.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,String> {
}
