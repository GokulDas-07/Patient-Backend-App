package com.nest.patientapp_backend.dao;

import com.nest.patientapp_backend.model.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientDao extends CrudRepository<Patient,Integer> {

    @Query(value = "SELECT 'id','patientid', `address`, `appointment`, `patientname`, `phone` FROM `patient` WHERE `patientid`=:patientid",nativeQuery = true)
    List<Patient> searchPatient(@Param("patientid") Integer patientid);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `patient` WHERE `patientid`=:patientid",nativeQuery = true)
    void deletePatient(@Param("patientid")Integer patientid);
}
