package com.nest.patientapp_backend.controller;

import com.nest.patientapp_backend.dao.PatientDao;
import com.nest.patientapp_backend.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {
    @Autowired
    private PatientDao dao;

    @CrossOrigin("*")
    @GetMapping("/")
    public String Homepage()
    {
        return "Home page";
    }

    @CrossOrigin("*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public String AddPatient(@RequestBody Patient p)
    {
        dao.save(p);
        return "Added patient";
    }
}
