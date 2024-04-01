package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import org.springframework.http.HttpStatus;

public interface PatientService {
    PatientTO findPatientById(Long patientId);

    HttpStatus deletePatient(Long patientId);
}
