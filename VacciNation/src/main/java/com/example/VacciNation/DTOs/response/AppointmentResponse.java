package com.example.VacciNation.DTOs.response;

import com.example.VacciNation.Enum.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;



@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AppointmentResponse {

    private String appointmentId;

    private Date dateOfAppointment;

    private AppointmentStatus status;

    private PatientResponse patientResponse;

    private String doctorName;

}
