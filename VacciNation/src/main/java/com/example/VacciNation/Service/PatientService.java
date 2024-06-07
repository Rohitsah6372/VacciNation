package com.example.VacciNation.Service;

import com.example.VacciNation.DTOs.request.PatientRequest;
import com.example.VacciNation.DTOs.response.PatientResponse;
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

    public PatientResponse addPatient(PatientRequest patientRequest) {
        //DTOs to model
        Patient patient = new Patient();
        patient.setName(patientRequest.getName());
        patient.setVaccinated(false);
        patient.setAge(patientRequest.getAge());
        patient.setGender(patientRequest.getGender());
        patient.setEmailId(patientRequest.getEmailId());

        Patient savedPatient =  patientRepository.save(patient);

        //model to DTOs

        PatientResponse patientResponse = new PatientResponse();

        patientResponse.setName(savedPatient.getName());
        patientResponse.setVaccinated(savedPatient.getVaccinated());
        patientResponse.setEmailId(savedPatient.getEmailId());

        return patientResponse;



    }

    public PatientResponse getPatient(int id) {
       Optional<Patient> optionalPatient =  patientRepository.findById(id);
       if(optionalPatient.isEmpty()){
            throw new PatientNotFoundException("Invalid Patient ID");
       }

       Patient patient = optionalPatient.get();
       PatientResponse patientResponse = new PatientResponse();

       patientResponse.setEmailId(patient.getEmailId());
       patientResponse.setName(patient.getName());
       patientResponse.setVaccinated(patient.getVaccinated());


       return patientResponse;

    }
}
