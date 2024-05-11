package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.List;

public interface PatientDAO extends Dao<PatientEntity, Long> {
    List<PatientEntity> findPatientBySurname(final String surname);
}
