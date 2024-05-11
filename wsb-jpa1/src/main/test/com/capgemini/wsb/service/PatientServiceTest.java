package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.DoctorDAO;
import com.capgemini.wsb.persistence.dao.VisitDAO;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PatientServiceTest {
    @Autowired
    private PatientService patientService;
    @Autowired
    private VisitDAO visitDAO;
    @Autowired
    private DoctorDAO doctorDAO;

    @Test
    public void testShouldFindPatientByIdTest() {
        // given
        final Long patientId = 1L;

        // when
        final PatientTO result = patientService.findPatientById(patientId);

        // then
        Assertions.assertNotNull(result);
        Assertions.assertEquals("jan.nowak@yopmail.com", result.getEmail());
    }

    @Test
    public void testShouldNotFindPatientById() {
        // given
        final Long patientId = 10L;

        // when
        final PatientTO result = patientService.findPatientById(patientId);

        // then
        Assertions.assertNull(result);
    }

    @Test
    public void testShouldDeletePatientAndVisitButNoDoctorTest() {
        // given
        final Long patientId = 1L;
        final Long visitId = 1L;
        final Long doctorId = 1L;

        // when
        final PatientTO deletedPatient = patientService.deletePatient(patientId);

        // then
        Assertions.assertEquals(patientId, deletedPatient.getId());
        Assertions.assertNull(patientService.findPatientById(patientId));
        Assertions.assertNull(visitDAO.findOne(visitId));
        Assertions.assertNotNull(doctorDAO.findOne(doctorId));
    }

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
        Assertions.assertEquals(visitDAO.findOne(visitId).getDescription(), result.getVisits().get(0).getDescription());
        Assertions.assertEquals(doctorDAO.findOne(doctorId).getSpecialization(), result.getVisits().get(0).getDoctor().getSpecialization());
    }
}
