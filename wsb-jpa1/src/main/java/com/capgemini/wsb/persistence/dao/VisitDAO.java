package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.List;

public interface VisitDAO extends Dao<VisitEntity, Long> {
    List<VisitEntity> getAllForPatient(Long patientId);
}
