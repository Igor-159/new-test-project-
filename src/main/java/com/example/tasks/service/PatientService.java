package com.example.tasks.service;

import com.example.tasks.dto.PatientDto;
import com.example.tasks.entity.Doctor;
import com.example.tasks.entity.Patient;

import java.util.Optional;

public interface PatientService {

    Patient register(PatientDto patientDto);

    Optional<Patient> findById(Long id);
}
