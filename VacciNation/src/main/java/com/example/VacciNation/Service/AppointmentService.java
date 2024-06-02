package com.example.VacciNation.Service;

import com.example.VacciNation.Exception.PatientNotFoundException;
import com.example.VacciNation.Model.Appointment;

import com.example.VacciNation.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {


    @Autowired
    AppointmentRepository appointmentRepository;


    public void bookAppointment(Appointment appointment) {
            appointmentRepository.save(appointment);

    }
}
