package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.DoctorDAO;
import com.capgemini.wsb.persistence.dao.VisitDAO;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {
    @Autowired
    private PatientService patientService;
    @Autowired
    private VisitDAO visitDAO;
    @Autowired
    private DoctorDAO doctorDAO;

    @Transactional
    @Test
    public void testShouldFindPatientById() {
        // given
        final Long patientId = 1L;

        // when
        final PatientTO result = patientService.findPatientById(patientId);

        // then
        Assertions.assertNotNull(result);
        Assertions.assertEquals("jan.nowak@yopmail.com", result.getEmail());
    }

    @Transactional
    @Test
    public void testShouldNotFindPatientById() {
        // given
        final Long patientId = 3L;

        // when
        final PatientTO result = patientService.findPatientById(patientId);

        // then
        Assertions.assertNull(result);
    }

    @Transactional
    @Test
    public void testShouldDeletePatientAndVisitButNoDoctor() {
        // given
        final Long patientId = 1L;
        final Long visitId = 1L;
        final Long doctorId = 1L;

        // when
        final HttpStatus deletedPatient = patientService.deletePatient(patientId);

        // then
        Assertions.assertEquals(200, deletedPatient.value());
        Assertions.assertNull(patientService.findPatientById(patientId));
        Assertions.assertNull(visitDAO.findOne(visitId));
        Assertions.assertNotNull(doctorDAO.findOne(doctorId));
    }

    @Transactional
    @Test
    public void testShouldResultHaveProperStructure() {
        // given
        final Long patientId = 1L;
        final Long visitId = 1L;
        final Long doctorId = 1L;

        // when
        final PatientTO result = patientService.findPatientById(patientId);

        // then
        Assertions.assertNotNull(result);
        Assertions.assertEquals(visitDAO.findOne(visitId), result.getVisits().get(0));
        Assertions.assertEquals(doctorDAO.findOne(doctorId), result.getVisits().get(0).getDoctor());
    }
}
