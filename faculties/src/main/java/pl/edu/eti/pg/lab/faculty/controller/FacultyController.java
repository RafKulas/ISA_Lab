package pl.edu.eti.pg.lab.faculty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.edu.eti.pg.lab.faculty.dto.CreateFacultyRequest;
import pl.edu.eti.pg.lab.faculty.dto.GetFacultiesResponse;
import pl.edu.eti.pg.lab.faculty.dto.GetFacultyResponse;
import pl.edu.eti.pg.lab.faculty.dto.UpdateFacultyRequest;
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

	@GetMapping
	public ResponseEntity<GetFacultiesResponse> getFaculties() {
		return ResponseEntity.ok(GetFacultiesResponse.entityToDtoMapper().apply(facultyService.findAll()));
	}

	@GetMapping("{name}")
	public ResponseEntity<GetFacultyResponse> getFaculty(@PathVariable("name") String name) {
		Optional<Faculty> faculty = facultyService.find(name);
		return faculty.map(f -> ResponseEntity.ok(GetFacultyResponse.entityToDtoMapper().apply(f)))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
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

	@PutMapping("{name}")
	public ResponseEntity<Void> updateFaculty(@RequestBody UpdateFacultyRequest request,
											  @PathVariable("name") String name) {
		Optional<Faculty> faculty = facultyService.find(name);
		if (faculty.isPresent()) {
			UpdateFacultyRequest.dtoToEntityUpdater().apply(faculty.get(), request);
			facultyService.update(faculty.get());
			return ResponseEntity.accepted().build();
		}
		return ResponseEntity.notFound().build();
	}

//	@GetMapping("dean/{dean}")
//	public ResponseEntity<GetFacultyResponse> getFacultyByDean(@PathVariable("dean") String dean) {
//		Optional<Faculty> faculty = facultyService.findByDean(dean);
//		return faculty.map(f -> ResponseEntity.ok(GetFacultyResponse.entityToDtoMapper().apply(f)))
//				.orElseGet(() -> ResponseEntity.notFound().build());
//	}
}
