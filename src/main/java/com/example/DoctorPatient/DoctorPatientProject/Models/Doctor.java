package com.example.DoctorPatient.DoctorPatientProject.Models;


import com.example.DoctorPatient.DoctorPatientProject.Enums.City;
import com.example.DoctorPatient.DoctorPatientProject.Enums.Speciality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 20)
    private City city;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false,length = 10)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Speciality speciality;
}
