package com.example.DoctorPatient.DoctorPatientProject.Service;

import com.example.DoctorPatient.DoctorPatientProject.Models.Patient;
import com.example.DoctorPatient.DoctorPatientProject.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public Patient addPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public void removePatient(Long id){
        patientRepository.deleteById(id);
    }
}
