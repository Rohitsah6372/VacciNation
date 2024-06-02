package com.example.VacciNation.Exception;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(String message){
        super(message);
    }

}
