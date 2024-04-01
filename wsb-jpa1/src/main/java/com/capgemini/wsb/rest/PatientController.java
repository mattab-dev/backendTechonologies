package com.capgemini.wsb.rest;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/patient/{id}")
    public PatientTO getPatientById(@PathVariable final Long id) {
        final PatientTO patient = patientService.findPatientById(id);
        if(patient != null) {
            return patient;
        }
        throw new EntityNotFoundException(id);
    }

    @PostMapping("/patient/remove/{id}")
    public HttpStatus deletePatientById(@PathVariable final Long id) {
        return patientService.deletePatient(id);
    }
}
