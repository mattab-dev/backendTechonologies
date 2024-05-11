package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.DetailVisitTO;

import java.util.List;

public interface VisitService {
    List<DetailVisitTO> getVisitsForPatient(Long patientId);
}
