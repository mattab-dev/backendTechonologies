package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.enums.TreatmentType;

import java.io.Serializable;

public class TreatmentTO implements Serializable {
    private String description;
    private TreatmentType treatmentType;

    public TreatmentTO() {

    }

    public TreatmentTO(String description, TreatmentType treatmentType) {
        this.description = description;
        this.treatmentType = treatmentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TreatmentType getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(TreatmentType treatmentType) {
        this.treatmentType = treatmentType;
    }
}
