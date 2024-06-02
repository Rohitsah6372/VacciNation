package com.example.VacciNation.Service;

import com.example.VacciNation.Exception.PatientNotFoundException;
import com.example.VacciNation.Model.Patient;
import com.example.VacciNation.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public Patient getPatient(int id) {
       Optional<Patient> optionalPatient =  patientRepository.findById(id);
       if(optionalPatient.isEmpty()){
            throw new PatientNotFoundException("Invalid Patient ID");
       }

       Patient patient = optionalPatient.get();

       return patient;

    }
}
