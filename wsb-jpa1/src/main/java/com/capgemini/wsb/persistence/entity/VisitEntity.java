package com.capgemini.wsb.persistence.entity;

import com.fasterxml.jackson.annotation.JacksonInject;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public List<MedicalTreatmentEntity> getMedicalTreatmentEntityList() {
		return medicalTreatmentEntityList;
	}

	public void setMedicalTreatmentEntityList(List<MedicalTreatmentEntity> medicalTreatmentEntityList) {
		this.medicalTreatmentEntityList = medicalTreatmentEntityList;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}
}
