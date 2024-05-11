package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDAO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDAOImpl extends AbstractDao<PatientEntity, Long> implements PatientDAO{
    @Override
    public List<PatientEntity>findPatientBySurname(String surname) {
        return entityManager.createQuery("select p from PatientEntity p where p.surname = :surname")
                .setParameter("surname", surname).getResultList();
    }
}
