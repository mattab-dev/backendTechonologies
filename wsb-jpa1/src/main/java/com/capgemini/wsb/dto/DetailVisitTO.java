package com.capgemini.wsb.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class DetailVisitTO implements Serializable {
    private String description;
    private LocalDateTime date;
    private DoctorTO doctor;
    private List<TreatmentTO> treatment;

    public DetailVisitTO() {

    }

    public DetailVisitTO(String description, LocalDateTime date, DoctorTO doctor, List<TreatmentTO> treatment) {
        this.description = description;
        this.date = date;
        this.doctor = doctor;
        this.treatment = treatment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public DoctorTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorTO doctor) {
        this.doctor = doctor;
    }

    public List<TreatmentTO> getTreatment() {
        return treatment;
    }

    public void setTreatment(List<TreatmentTO> treatment) {
        this.treatment = treatment;
    }
}
