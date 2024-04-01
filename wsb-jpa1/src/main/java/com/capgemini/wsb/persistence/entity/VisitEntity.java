package com.capgemini.wsb.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(name = "VISIT")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 19)
	private Long id;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "TIME", nullable = false)
	private LocalDateTime time;
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private DoctorEntity doctor;
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;
	@OneToMany(mappedBy = "visit")
	private List<MedicalTreatmentEntity> medicalTreatmentEntityList;

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public void setMedicalTreatmentEntityList(List<MedicalTreatmentEntity> medicalTreatmentEntityList) {
		this.medicalTreatmentEntityList = medicalTreatmentEntityList;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}
}
