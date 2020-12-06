package pl.edu.eti.pg.lab.faculty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.edu.eti.pg.lab.faculty.dto.CreateFacultyRequest;
import pl.edu.eti.pg.lab.faculty.entity.Faculty;
import pl.edu.eti.pg.lab.faculty.service.FacultyService;

import java.util.Optional;

@RestController
@RequestMapping("api/faculties")
public class FacultyController {

	private final FacultyService facultyService;

	@Autowired
	public FacultyController(FacultyService facultyService) {
		this.facultyService = facultyService;
	}

	@PostMapping("")
	public ResponseEntity<Void> createFaculty(@RequestBody CreateFacultyRequest request,
											  UriComponentsBuilder builder) {
		Faculty faculty = CreateFacultyRequest
				.dtoToEntityMapper().apply(request);
		facultyService.create(faculty);
		return ResponseEntity.created(
				builder.pathSegment("api", "faculties", "{name}")
				.buildAndExpand(faculty.getName()).toUri()).build();
	}

	@DeleteMapping("{name}")
	public ResponseEntity<Void> deleteFaculty(@PathVariable("name") String name) {
		Optional<Faculty> faculty = facultyService.find(name);
		if(faculty.isPresent()) {
			facultyService.delete(faculty.get());
			return ResponseEntity.accepted().build();
		}
		return ResponseEntity.notFound().build();
	}
}
