package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PatientTOMapper {
    PatientTO map(PatientEntity source);
}
