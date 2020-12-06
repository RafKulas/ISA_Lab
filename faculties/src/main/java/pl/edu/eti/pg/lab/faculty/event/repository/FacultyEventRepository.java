package pl.edu.eti.pg.lab.faculty.event.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.edu.eti.pg.lab.faculty.entity.Faculty;
import pl.edu.eti.pg.lab.faculty.event.dto.CreateFacultyRequest;

@Repository
public class FacultyEventRepository {

	private RestTemplate restTemplate;

	@Autowired
	public FacultyEventRepository(@Value("${study.students.url}") String baseURL) {
		restTemplate = new RestTemplateBuilder().rootUri(baseURL).build();
	}

	public void delete(Faculty faculty) {
		restTemplate.delete("/faculties/{faculty}", faculty.getName());
	}

	public void create(Faculty faculty) {
		restTemplate.postForLocation("/faculties", CreateFacultyRequest.entityToDtoMapper().apply(faculty));
	}
}
