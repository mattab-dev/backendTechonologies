package com.capgemini.wsb.rest;

import com.capgemini.wsb.dto.DetailVisitTO;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.VisitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class VisitController {
    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping("/visit/{patientId}")
    public ResponseEntity<List<DetailVisitTO>> getVisitsByPatientId(@PathVariable Long patientId) {
        final List<DetailVisitTO> visitList = visitService.getVisitsForPatient(patientId);
        if(visitList.isEmpty()) {
            throw new EntityNotFoundException(patientId);
        }
        return ok(visitList);
    }
}
