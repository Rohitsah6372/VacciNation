package com.example.VacciNation.Controller;

import com.example.VacciNation.Model.Patient;
import com.example.VacciNation.Service.PatientService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/patient")
public class PatientController {

        @Autowired
        PatientService patientService;

        @PostMapping("/add")
        private ResponseEntity addPatient(@RequestBody Patient patient){
            try{
                    patientService.addPatient(patient);
                    return new ResponseEntity("Patient has been added", HttpStatus.CREATED);
            }catch (Exception e){
                    return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

            }
        }

        @GetMapping("/getPatient")
        private Patient getPatient(@RequestParam("id") int id){
                return patientService.getPatient(id);
        }

}
