package com.example.VacciNation.Service;


import com.example.VacciNation.Enum.Vaccine;

import com.example.VacciNation.Exception.PatientNotFoundException;
import com.example.VacciNation.Model.Dose;
import com.example.VacciNation.Model.Patient;
import com.example.VacciNation.Repository.DoseRepository;
import com.example.VacciNation.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class DoseService {

    @Autowired
    DoseRepository doseRepository;

    @Autowired
    PatientRepository patientRepository;

    public Dose addDose(int id,Vaccine vaccine) {

        //check if patient is valid or not
        Optional<Patient> optionalPatient = patientRepository.findById(id);

        if(optionalPatient.isEmpty()){
            throw new PatientNotFoundException("Invalid Patient Id");
        }

        Patient patient = optionalPatient.get();

        //check whether patient is already vaccinated or not
        if(patient.getVaccinated()){
            throw new RuntimeException("Patient is Already Vaccinated");
        }


        //if patient is already not vaccinated
        patient.setVaccinated(true);

        Dose dose = new Dose();
        dose.setVaccine(vaccine);

        dose.setSerialNumber(String.valueOf(UUID.randomUUID()));

        //setting the foriegn key
        dose.setPatient(patient);

        patientRepository.save(patient);

       return doseRepository.save(dose);


    }

}
