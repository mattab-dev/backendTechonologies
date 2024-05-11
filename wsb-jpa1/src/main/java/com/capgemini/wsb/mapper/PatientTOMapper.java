package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.SimplePatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.stream.Collectors;

public final class PatientTOMapper {
    public static PatientTO mapToTO(PatientEntity patient) {
        if(patient == null) {
            return null;
        }
        return new PatientTO(patient.getId(), //
                patient.getFirstName(),//
                patient.getLastName(), //
                patient.getEmail(), //
                patient.getWeight(), //
                patient.getVisits().stream().map(VisitTOMapper::mapToTO).collect(Collectors.toList()));
    }

    public static SimplePatientTO mapToSimpleTO(PatientEntity patient) {
        if(patient == null) {
            return null;
        }
        return new SimplePatientTO(patient.getFirstName(),//
                patient.getLastName());
    }
}
