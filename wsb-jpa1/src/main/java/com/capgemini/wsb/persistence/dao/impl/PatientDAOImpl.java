package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDAO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PatientDAOImpl extends AbstractDao<PatientEntity, Long> implements PatientDAO{

}
