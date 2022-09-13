package pl.edu.eti.pg.lab.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.edu.eti.pg.lab.student.entity.Student;

import java.util.Collection;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
public class GetFieldsOfStudyResponse {
	Set<String> fieldsOfStudy;

	public static Function<Collection<Student>, GetFieldsOfStudyResponse> entityToDtoMapper() {
		return students -> {
			Set<String> fields =
					students.stream()
							.map(Student::getFieldOfStudies)
							.collect(Collectors.toSet());
			return new GetFieldsOfStudyResponse(fields);
		};
	}
}
