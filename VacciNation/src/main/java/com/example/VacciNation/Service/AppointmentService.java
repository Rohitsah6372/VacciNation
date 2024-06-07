package com.example.VacciNation.Service;

import com.example.VacciNation.DTOs.response.AppointmentResponse;
import com.example.VacciNation.DTOs.response.PatientResponse;
import com.example.VacciNation.Enum.AppointmentStatus;
import com.example.VacciNation.Exception.DoctorNotFoundException;
import com.example.VacciNation.Exception.PatientNotFoundException;
import com.example.VacciNation.Model.Appointment;

import com.example.VacciNation.Model.Doctor;
import com.example.VacciNation.Model.Patient;
import com.example.VacciNation.Repository.AppointmentRepository;
import com.example.VacciNation.Repository.DoctorRepository;
import com.example.VacciNation.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {


    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;


    public AppointmentResponse bookAppointment(int pid, int did) {

       Optional<Patient> patientOptional = patientRepository.findById(pid);
        if(patientOptional.isEmpty()){
            throw new PatientNotFoundException("Invalid patient Id");
        }

        Optional<Doctor> optionalDoctor = doctorRepository.findById(did);
        if(optionalDoctor.isEmpty()){
            throw new DoctorNotFoundException("Invalid Doctor ID");
        }

        Patient patient = patientOptional.get();
        Doctor doctor = optionalDoctor.get();

        //Book the Appointment
        Appointment appointment = new Appointment();

        appointment.setAppointmentId(UUID.randomUUID().toString());

        appointment.setStatus(AppointmentStatus.BOOKED);

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);


        Appointment savedAppointment = appointmentRepository.save(appointment);


        //Model to DTOs

        AppointmentResponse appointmentResponse = new AppointmentResponse();
        appointmentResponse.setAppointmentId(savedAppointment.getAppointmentId());
        appointmentResponse.setStatus(savedAppointment.getStatus());
        appointmentResponse.setDoctorName(savedAppointment.getDoctor().getName());

        Patient savedPatient = savedAppointment.getPatient();
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setName(savedPatient.getName());
        patientResponse.setEmailId(savedPatient.getEmailId());
        patientResponse.setVaccinated(savedPatient.getVaccinated());

        appointmentResponse.setPatientResponse(patientResponse);





        return appointmentResponse;

    }
}
