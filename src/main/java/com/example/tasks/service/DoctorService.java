package com.example.tasks.service;

import com.example.tasks.dto.DoctorDto;
import com.example.tasks.dto.DoctorResponseDto;
import com.example.tasks.entity.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    Doctor register(DoctorDto doctorDto);
    Optional<Doctor> findById(Long id);

    Doctor update (Long id, DoctorDto doctorDto);
}
