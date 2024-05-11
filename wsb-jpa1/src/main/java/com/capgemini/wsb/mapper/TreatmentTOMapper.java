package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.TreatmentTO;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;

public final class TreatmentTOMapper {
    public static TreatmentTO mapToTO(MedicalTreatmentEntity treatment) {
        if(treatment == null) {
            return null;
        }
        return new TreatmentTO(
                treatment.getDescription(), //
                treatment.getType());
    }
}
