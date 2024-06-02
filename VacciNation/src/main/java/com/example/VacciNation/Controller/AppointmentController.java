package com.example.VacciNation.Controller;

import com.example.VacciNation.Model.Appointment;
import com.example.VacciNation.Model.Patient;
import com.example.VacciNation.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book")
    private ResponseEntity bookAppointment(@RequestParam("pid") int patientId,
                                           @RequestParam("did") int doctor_id){
        try{
            Appointment bookAppointment  =   appointmentService.bookAppointment(patientId, doctor_id);

            return new ResponseEntity(bookAppointment, HttpStatus.CREATED);

        }catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }


}
