package com.example.DoctorPatient.DoctorPatientProject.Repository;

import com.example.DoctorPatient.DoctorPatientProject.Enums.City;
import com.example.DoctorPatient.DoctorPatientProject.Enums.Speciality;
import com.example.DoctorPatient.DoctorPatientProject.Models.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor,Long> {

    List<Doctor> findByCityAndSpeciality(City city, Speciality speciality);

    Doctor findByCity(City city);

    Doctor findBySpeciality(Speciality speciality);
}
