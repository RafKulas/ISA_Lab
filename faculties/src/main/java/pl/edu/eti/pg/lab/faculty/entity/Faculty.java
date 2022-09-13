package pl.edu.eti.pg.lab.faculty.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "faculties")
public class Faculty implements Serializable {

	@Id
	@Column(name = "name")
	private String name;

	@Column(name = "dean", unique = true)
	private String dean;

	@Column(name = "amount_of_students")
	private int amountOfStudents;
}
