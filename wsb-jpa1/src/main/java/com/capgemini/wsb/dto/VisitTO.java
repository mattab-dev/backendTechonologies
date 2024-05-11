package com.capgemini.wsb.dto;

import java.io.Serializable;

public class VisitTO implements Serializable {
    private String description;
    private DoctorTO doctor;
    private SimplePatientTO patient;

    public VisitTO() {

    }

    public VisitTO(String description, DoctorTO doctor, SimplePatientTO patient) {
        this.description = description;
        this.doctor = doctor;
        this.patient = patient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DoctorTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorTO doctor) {
        this.doctor = doctor;
    }

    public SimplePatientTO getPatient() {
        return patient;
    }

    public void setPatient(SimplePatientTO patient) {
        this.patient = patient;
    }
}
