package com.example.VacciNation.Controller;

import com.example.VacciNation.Model.Doctor;
import com.example.VacciNation.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor){
        try {
            doctorService.addDoctor(doctor);
            return "Succeded";
        }catch (Exception e){
            return "Error in Doctor";
        }
    }



}
