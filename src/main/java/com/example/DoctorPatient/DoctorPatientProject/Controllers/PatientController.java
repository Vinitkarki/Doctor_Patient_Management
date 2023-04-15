package com.example.DoctorPatient.DoctorPatientProject.Controllers;

import com.example.DoctorPatient.DoctorPatientProject.Models.Patient;
import com.example.DoctorPatient.DoctorPatientProject.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.DoctorPatient.DoctorPatientProject.Enums.Symptom.*;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("api/patients")
    public ResponseEntity addPatient(@RequestBody Patient patient){

        return new ResponseEntity<>(patientService.addPatient(patient), HttpStatus.CREATED);
    }

    @DeleteMapping("api/patients/{id}")
    public void removePatient(@PathVariable Long id){
        patientService.removePatient(id);
    }
}
