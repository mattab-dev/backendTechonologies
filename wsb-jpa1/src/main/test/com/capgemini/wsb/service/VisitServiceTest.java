package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.DetailVisitTO;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class VisitServiceTest {
    @Autowired
    private VisitService visitService;

    @Test
    public void testShouldFindPatientWithMultipleVisits(){
        // given
        final Long patientId = 3L;

        // when
        final List<DetailVisitTO> visits = visitService.getVisitsForPatient(patientId);

        // then
        Assertions.assertEquals(3, visits.size());
        Assertions.assertEquals("okulista", visits.get(0).getDescription());
        Assertions.assertEquals("lekarz rodzinny", visits.get(1).getDescription());
        Assertions.assertEquals("dermatologia", visits.get(2).getDescription());



    }
}
