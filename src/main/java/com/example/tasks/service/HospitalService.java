package com.example.tasks.service;

import com.example.tasks.dto.HospitalDto;
import com.example.tasks.dto.PatientDto;
import com.example.tasks.entity.Hospital;
import com.example.tasks.entity.Patient;

import java.util.Optional;

public interface HospitalService {

    Hospital register(HospitalDto hospitalDto);

    Optional<Hospital> findById(Long id);
}
