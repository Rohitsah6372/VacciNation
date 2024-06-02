package com.example.VacciNation.Controller;



import com.example.VacciNation.Enum.Vaccine;
import com.example.VacciNation.Model.Dose;
import com.example.VacciNation.Service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    DoseService doseService;

    @PostMapping("/vaccinatedvaccinated")
    public Dose addDose(@RequestParam("id") int patientId, @RequestParam("brand")Vaccine vaccine){
       return doseService.addDose(patientId, vaccine);
    }

}
