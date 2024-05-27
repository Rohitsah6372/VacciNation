package com.example.VacciNation;

import com.example.VacciNation.Enum.DayOfWeek;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VacciNationApplication {

	public static void main(String[] args) {
		SpringApplication.run(VacciNationApplication.class, args);
	}

	DayOfWeek day = DayOfWeek.MONDAY;

}
