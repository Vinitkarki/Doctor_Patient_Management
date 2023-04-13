package com.example.DoctorPatient.DoctorPatientProject.Repository;

import com.example.DoctorPatient.DoctorPatientProject.Models.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient,Long> {
}
