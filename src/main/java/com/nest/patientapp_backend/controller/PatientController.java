package com.nest.patientapp_backend.controller;

import com.nest.patientapp_backend.dao.PatientDao;
import com.nest.patientapp_backend.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientDao dao;

    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public String Homepage()
    {
        return "Home page";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public String AddPatient(@RequestBody Patient p)
    {
        dao.save(p);
        return "Added patient";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Patient> ViewPatients()
    {
        return (List<Patient>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Patient> searchPatient(@RequestBody Patient p)
    {
        String patientid=String.valueOf(p.getPatientid());
        System.out.println(patientid);
        return (List<Patient>) dao.searchPatient(p.getPatientid());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> deletePatient(@RequestBody Patient p)
    {
        String patientid=String.valueOf(p.getPatientid());
        System.out.println(patientid);
        dao.deletePatient(p.getPatientid());
        HashMap<String,String> map =new HashMap<>();
        map.put("status","success");
        return map;
    }

}
