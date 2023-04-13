package com.example.DoctorPatient.DoctorPatientProject.Service;

import com.example.DoctorPatient.DoctorPatientProject.Enums.City;
import com.example.DoctorPatient.DoctorPatientProject.Enums.Speciality;
import com.example.DoctorPatient.DoctorPatientProject.Models.Doctor;
import com.example.DoctorPatient.DoctorPatientProject.Models.Patient;
import com.example.DoctorPatient.DoctorPatientProject.Repository.DoctorRepository;
import com.example.DoctorPatient.DoctorPatientProject.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.DoctorPatient.DoctorPatientProject.Enums.City.*;
import static com.example.DoctorPatient.DoctorPatientProject.Enums.Speciality.*;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    public Doctor addDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public void removeDoctor(Long id){

        doctorRepository.deleteById(id);
    }

    public ResponseEntity suggestDoctors(Long patientId){

        Patient patient=patientRepository.findById(patientId).orElse(null);
        if(patient==null){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST) ;
        }
//        return new ResponseEntity( doctorRepository.findByCityAndSpeciality(patient.getCity(),getSpeciality(patient.getSymptom())),HttpStatus.ACCEPTED);
        List<Doctor> doctors = new ArrayList<>();
        doctors=doctorRepository.findByCityAndSpeciality(getCityEnum(patient.getCity()),getSpeciality(patient.getSymptom().toString()));
        if(!doctors.isEmpty()){
            return new ResponseEntity<>(doctors,HttpStatus.OK);
        }
        else{
            Doctor doctor=doctorRepository.findByCity(getCityEnum(patient.getCity()));


            if(doctor!=null){
                return new ResponseEntity<>("There isn't any doctor present at your location for your symptom",HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("We are still waiting to expand to your location",HttpStatus.OK);
            }

        }
    }

    private Speciality getSpeciality(String symptom){

        return switch (symptom) {
            case "Arthritis", "Backpain", "Tissue_injuries" -> Orthopedic;
            case "Dysmenorrhea" -> Gynecology;
            case "Skin_infection", "Skin_burn" -> Dermatology;
            case "Ear_pain" -> ENT_specialist;
            default -> null;
        };
    }

    private City getCityEnum(String city){
        return switch (city){
            case "Delhi" -> Delhi;
            case "Noida" -> Noida;
            case "Faridabad" -> Faridabad;
            default -> null;
        };
    }
}
