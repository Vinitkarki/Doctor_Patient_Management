package com.example.DoctorPatient.DoctorPatientProject.Controllers;

import com.example.DoctorPatient.DoctorPatientProject.Enums.City;
import com.example.DoctorPatient.DoctorPatientProject.Models.Doctor;
import com.example.DoctorPatient.DoctorPatientProject.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.DoctorPatient.DoctorPatientProject.Enums.City.*;
import static com.example.DoctorPatient.DoctorPatientProject.Enums.Speciality.*;


@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("api/doctors")
    public ResponseEntity addDoctor(@RequestBody Doctor doctor){


            Doctor addedDoctor= doctorService.addDoctor(doctor);
            return new ResponseEntity<>(addedDoctor, HttpStatus.CREATED);
    }

    @DeleteMapping("api/doctors/{id}")
    public ResponseEntity<Void> removeDoctor(@PathVariable Long id){
        doctorService.removeDoctor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("api/doctors/suggestDoctors/{id}")
    public ResponseEntity suggestDoctors(@PathVariable Long id){

        return doctorService.suggestDoctors(id);
    }

}
