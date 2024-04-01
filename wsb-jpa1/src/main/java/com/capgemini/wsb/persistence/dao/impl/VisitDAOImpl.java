package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.VisitDAO;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

@Repository
public class VisitDAOImpl extends AbstractDao<VisitEntity, Long> implements VisitDAO {
}
