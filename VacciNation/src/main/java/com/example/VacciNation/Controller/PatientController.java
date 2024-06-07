package com.example.VacciNation.Controller;

import com.example.VacciNation.DTOs.request.PatientRequest;
import com.example.VacciNation.DTOs.response.PatientResponse;
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
        private ResponseEntity<PatientResponse> addPatient(@RequestBody PatientRequest patientRequest) {
                try {
                        PatientResponse patientResponse = patientService.addPatient(patientRequest);
                        return new ResponseEntity<>(patientResponse, HttpStatus.CREATED);
                } catch (Exception e) {
                        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                }
        }


        @GetMapping("/getPatient")
        private PatientResponse getPatient(@RequestParam("id") int id){
                PatientResponse patientResponse = patientService.getPatient(id);
                return patientResponse;
        }

}
