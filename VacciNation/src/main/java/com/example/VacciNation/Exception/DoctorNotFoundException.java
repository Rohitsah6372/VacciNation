package com.example.VacciNation.Exception;

public class DoctorNotFoundException extends RuntimeException {
        public DoctorNotFoundException(String message){
            super(message);
        }
}
