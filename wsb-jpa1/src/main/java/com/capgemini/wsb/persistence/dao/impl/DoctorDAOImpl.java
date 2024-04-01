package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.DoctorDAO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorDAOImpl extends AbstractDao<DoctorEntity, Long> implements DoctorDAO {
}
