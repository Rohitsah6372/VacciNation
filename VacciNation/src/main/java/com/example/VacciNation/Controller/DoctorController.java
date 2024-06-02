package com.example.VacciNation.Controller;

import com.example.VacciNation.Model.Doctor;
import com.example.VacciNation.Service.DoctorService;
import lombok.Getter;
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

    @GetMapping("/getDoctor")
    private Doctor getDoctor(@RequestParam("id") int id){
        return doctorService.getDoctor(id);
    }

    //delete a doctor
    @DeleteMapping("/delete")
    public String deleteDoctor(@RequestParam("id") int id){
        doctorService.deleteDocotor(id);
        return "Doctor Deleted";
    }



}
