package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientTOMapper;
import com.capgemini.wsb.persistence.dao.PatientDAO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PatientServiceImpl implements PatientService {
    private final PatientDAO patientDAO;
    private final PatientTOMapper mapper;

    @Override
    public PatientTO findPatientById(Long patientId) {
        final PatientEntity dbPatient = patientDAO.findOne(patientId);
        return mapper.map(dbPatient);
    }

    @Override
    public HttpStatus deletePatient(Long patientId) {
        final PatientEntity dbPatient = patientDAO.findOne(patientId);
        if(dbPatient != null) {
            patientDAO.delete(dbPatient);
            return HttpStatus.OK;
        }
        throw new EntityNotFoundException(patientId);
    }
}
