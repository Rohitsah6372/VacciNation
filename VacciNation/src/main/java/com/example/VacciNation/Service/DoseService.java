package com.example.VacciNation.Service;


import com.example.VacciNation.Enum.Vaccine;

import com.example.VacciNation.Model.Dose;
import com.example.VacciNation.Model.Patient;
import com.example.VacciNation.Repository.DoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DoseService {

    @Autowired
    DoseRepository doseRepository;

    public void addDose(Dose dose) {
        doseRepository.save(dose);
    }

}
