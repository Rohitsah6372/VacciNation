package com.example.VacciNation.Service;

import com.example.VacciNation.Exception.DoctorNotFoundException;
import com.example.VacciNation.Model.Doctor;
import com.example.VacciNation.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public void addDoctor(Doctor doctor) {

        doctorRepository.save(doctor);
    }

    public Doctor getDoctor(int docId){
        Optional<Doctor> optionalDoctor = doctorRepository.findById(docId);
        if(optionalDoctor.isEmpty()){
            throw  new DoctorNotFoundException("Invalid DoctorID");
        }
        return optionalDoctor.get();

    }

    public void deleteDocotor(int id) {
        doctorRepository.deleteById(id);
    }
}
