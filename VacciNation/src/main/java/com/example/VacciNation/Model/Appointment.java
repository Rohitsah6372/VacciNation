package com.example.VacciNation.Model;

import com.example.VacciNation.Enum.AppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;


import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String appointmentId;

    private Date dateOfAppointment;

    @CreationTimestamp
    private AppointmentStatus status;

    @ManyToOne
    @JoinColumn
    Doctor doctor;

    @OneToOne
    @JoinColumn
    Patient patient;



}
