package com.example.VacciNation.Controller;

import com.example.VacciNation.Model.Patient;
import com.example.VacciNation.Service.PatientService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/patient")
public class PatientController {

        @Autowired
        PatientService patientService;

        @PostMapping("/add")
        private String addPatient(@RequestBody Patient patient){
            patientService.addPatient(patient);
            return "Patient Added Successfully";
        }

        @GetMapping("/getPatient")
        private Patient getPatient(@RequestParam("id") int id){
                return patientService.getPatient(id);
        }

}
