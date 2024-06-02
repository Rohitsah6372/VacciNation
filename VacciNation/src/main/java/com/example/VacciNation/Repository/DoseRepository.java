package com.example.VacciNation.Repository;

import com.example.VacciNation.Model.Dose;
import com.example.VacciNation.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoseRepository extends JpaRepository<Dose, Integer> {

}
