package com.example.VacciNation.Controller;

import com.example.VacciNation.Model.Appointment;
import com.example.VacciNation.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/add")
    private void bookAppointment(@RequestBody Appointment appointment){
        appointmentService.bookAppointment(appointment);
    }


}
