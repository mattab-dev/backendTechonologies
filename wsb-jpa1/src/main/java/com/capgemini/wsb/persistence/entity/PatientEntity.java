package com.capgemini.wsb.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PATIENT")
public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 19)
	private Long id;
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	@Column(name = "TELEPHONE_NUMBER", nullable = false)
	private String telephoneNumber;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PATIENT_NUMBER", nullable = false)
	private String patientNumber;
	@Column(name = "DATE_OF_BIRTH", nullable = false)
	private LocalDate dateOfBirth;
	@Column(name = "WEIGHT")
	private Double weight;
	@OneToMany(mappedBy = "patient")
	private List<VisitEntity> visits;
}
