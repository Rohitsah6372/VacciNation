package com.example.VacciNation.Service;

import com.example.VacciNation.Model.Doctor;
import com.example.VacciNation.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public void addDoctor(Doctor doctor) {

        doctorRepository.save(doctor);
    }

}
