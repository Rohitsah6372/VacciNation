package com.example.VacciNation.DTOs.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PatientResponse {

    private String name;

    private boolean vaccinated;

    private String emailId;

}
