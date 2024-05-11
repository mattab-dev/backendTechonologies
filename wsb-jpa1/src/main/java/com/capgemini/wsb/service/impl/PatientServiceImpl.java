package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.SimplePatientTO;
import com.capgemini.wsb.mapper.PatientTOMapper;
import com.capgemini.wsb.persistence.dao.PatientDAO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.PatientService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static com.capgemini.wsb.mapper.PatientTOMapper.mapToTO;
import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    private final PatientDAO patientDAO;
    public PatientServiceImpl(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    public PatientTO findPatientById(Long patientId) {
        final PatientEntity dbPatient = patientDAO.findOne(patientId);
        return mapToTO(dbPatient);
    }

    @Override
    public PatientTO deletePatient(Long patientId) {
        final PatientEntity dbPatient = patientDAO.findOne(patientId);
        if(dbPatient != null) {
            patientDAO.delete(dbPatient);
            return PatientTOMapper.mapToTO(dbPatient);
        }
        throw new EntityNotFoundException(patientId);
    }

    @Override
    public List<SimplePatientTO> getPatientsBySurname(String surname) {
        final List<SimplePatientTO> resultList = new ArrayList<>();
        final List<PatientEntity> patients = patientDAO.findPatientBySurname(surname);
        if(!patients.isEmpty()) {
            resultList.addAll(patients.stream().map(PatientTOMapper::mapToSimpleTO).collect(toList()));
        }
        return resultList;
    }

    @Override
    public List<PatientTO> getByCount(int visitCount) {
        final List<PatientTO> resultList = new ArrayList<>();
        final List<PatientEntity> patients = patientDAO.findPatientsByVisitsCountGreaterThan(visitCount);
        if(!patients.isEmpty()) {
            resultList.addAll(patients.stream().map(PatientTOMapper::mapToTO).collect(toList()));
        }
        return resultList;
    }

    @Override
    public List<PatientTO> getPatientsHeavierThan(double weight) {
        final List<PatientTO> result = new ArrayList<>();
        final List<PatientEntity> patients = patientDAO.findPatientsHeavierThan(weight);
        if(!patients.isEmpty()) {
            result.addAll(patients.stream().map(PatientTOMapper::mapToTO).collect(toList()));
        }
        return result;
    }
}
