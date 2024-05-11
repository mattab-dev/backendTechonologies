package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DetailVisitTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import static java.util.stream.Collectors.toList;

public final class VisitTOMapper {
    public static VisitTO mapToTO(final VisitEntity visit) {
        if(visit == null) {
            return null;
        }
        return new VisitTO(
                visit.getDescription(), //
                DoctorTOMapper.mapToTO(visit.getDoctor()), //
                PatientTOMapper.mapToSimpleTO(visit.getPatient()));
    }

    public static DetailVisitTO mapToDetailTO(final VisitEntity visit) {
        if(visit == null) {
            return null;
        }
        return new DetailVisitTO(
                visit.getDescription(), //
                visit.getTime(), //
                DoctorTOMapper.mapToTO(visit.getDoctor()), //
                visit.getMedicalTreatmentEntityList().stream().map(TreatmentTOMapper::mapToTO).collect(toList()));
    }
}
