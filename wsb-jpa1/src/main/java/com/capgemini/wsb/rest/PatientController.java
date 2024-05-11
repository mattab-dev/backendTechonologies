package com.capgemini.wsb.rest;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.SimplePatientTO;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<PatientTO> getPatientById(@PathVariable final Long id) {
        final PatientTO patient = patientService.findPatientById(id);
        if(patient != null) {
            return ok(patient);
        }
        throw new EntityNotFoundException(id);
    }

    @PostMapping("/patient/remove/{id}")
    public ResponseEntity<PatientTO> deletePatientById(@PathVariable final Long id) {
        final PatientTO removedPatient = patientService.deletePatient(id);
        return new ResponseEntity<>(removedPatient, NO_CONTENT);
    }

    @GetMapping("/patient/surname/{surname}")
    public ResponseEntity<List<SimplePatientTO>> getPatientsBySurname(@PathVariable final String surname) {
        final List<SimplePatientTO> patients = patientService.getPatientsBySurname(surname);
        if(patients.isEmpty()) {
            throw new EntityNotFoundException(surname);
        }
        return ok(patients);
    }

    @GetMapping("/patient/visits/{count}")
    public ResponseEntity<List<PatientTO>> getPatientsBasedOnVisitCount(@PathVariable int count) {
        final List<PatientTO> patients = patientService.getByCount(count);
        if(patients.isEmpty()) {
            throw new EntityNotFoundException(count);
        }
        return ok(patients);
    }

    @GetMapping("/patient/weight/{value}")
    public ResponseEntity<List<PatientTO>> getPatientsBasedOnVisitCount(@PathVariable double value) {
        final List<PatientTO> patients = patientService.getPatientsHeavierThan(value);
        if(patients.isEmpty()) {
            throw new EntityNotFoundException(value);
        }
        return ok(patients);
    }
}
