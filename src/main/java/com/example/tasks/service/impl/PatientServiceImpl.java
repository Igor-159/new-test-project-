package com.example.tasks.service.impl;

import com.example.tasks.dto.DoctorDto;
import com.example.tasks.dto.PatientDto;
import com.example.tasks.entity.Doctor;
import com.example.tasks.entity.Patient;
import com.example.tasks.mapper.PatientMapper;
import com.example.tasks.repository.PatientRepository;
import com.example.tasks.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Transactional
    @Override
    public Patient register(PatientDto patientDto) {
        return Optional.of(patientDto)
                .map(patientMapper::toEntity)
                .map(patientRepository::save)
                .orElseThrow();
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }
}
