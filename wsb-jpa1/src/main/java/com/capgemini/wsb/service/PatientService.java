package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.SimplePatientTO;

import java.util.List;

public interface PatientService {
    PatientTO findPatientById(Long patientId);

    PatientTO deletePatient(Long patientId);

    List<SimplePatientTO> getPatientsBySurname(String surname);

    List<PatientTO> getByCount(int visitCount);

    List<PatientTO> getPatientsHeavierThan(double weight);
}
