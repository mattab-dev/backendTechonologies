package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDAO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDAOTest {
    @Autowired
    private PatientDAO patientDAO;

    @Test
    public void testShouldFindPatientsBySurnameTest() {
        // given
        final String surname = "Panda";

        // when
        final List<PatientEntity> patients = patientDAO.findPatientBySurname(surname);

        // then
        Assertions.assertEquals(3, patients.size());
    }

    @Test
    public void testShouldFindPatientWithVisitCountGreaterThanTest() {
        // given
        final int visitCount = 1;

        // when
        final List<PatientEntity> patients = patientDAO.findPatientsByVisitsCountGreaterThan(visitCount);

        // then
        Assertions.assertEquals(1, patients.size());
    }

    @Test
    public void testShouldFindPatientsHeavierThanGivenTest() {
        // given
        final double weight = 95.0;

        // when
        final List<PatientEntity> patients = patientDAO.findPatientsHeavierThan(weight);

        // then
        Assertions.assertEquals(1, patients.size());
        Assertions.assertEquals("Krzysztof", patients.get(0).getFirstName());
    }
}
