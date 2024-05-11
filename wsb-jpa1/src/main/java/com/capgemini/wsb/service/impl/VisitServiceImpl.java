package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.DetailVisitTO;
import com.capgemini.wsb.mapper.VisitTOMapper;
import com.capgemini.wsb.persistence.dao.VisitDAO;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.VisitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class VisitServiceImpl implements VisitService {
    private final VisitDAO visitDAO;

    public VisitServiceImpl(VisitDAO visitDAO) {
        this.visitDAO = visitDAO;
    }

    @Override
    public List<DetailVisitTO> getVisitsForPatient(Long patientId) {
        final List<DetailVisitTO> result = new ArrayList<>();
        final List<VisitEntity> visits = visitDAO.getAllForPatient(patientId);
        if(!visits.isEmpty()) {
            result.addAll(visits.stream().map(VisitTOMapper::mapToDetailTO).collect(toList()));
        }
        return result;
    }
}
