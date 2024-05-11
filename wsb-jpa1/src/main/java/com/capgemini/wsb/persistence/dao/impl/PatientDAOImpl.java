package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDAO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDAOImpl extends AbstractDao<PatientEntity, Long> implements PatientDAO{
    @Override
    public List<PatientEntity>findPatientBySurname(String surname) {
        return entityManager.createQuery("select p from PatientEntity p where lower(p.lastName) = lower(:surname)")
                .setParameter("surname", surname).getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsHeavierThan(double weight) {
        return entityManager.createQuery("select p from PatientEntity p where p.weight > :weight").setParameter("weight", weight).getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsByVisitsCountGreaterThan(long countValue) {
        return entityManager.createQuery(
                        "SELECT p FROM PatientEntity p JOIN FETCH p.visits v GROUP BY p.id HAVING COUNT(v.id) > :count")
                .setParameter("count", countValue)
                .getResultList();
    }
}
