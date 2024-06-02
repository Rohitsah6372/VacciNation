package com.example.VacciNation.Model;


import com.example.VacciNation.Enum.Vaccine;
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
public class Dose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String serialNumber;

    @Enumerated(value = EnumType.STRING)
    private Vaccine vaccine;


    @CreationTimestamp
    private Date dateOfVaccination;

    @OneToOne
    @JoinColumn
    Patient patient;

}
