package com.example.tasks.service.impl;

import com.example.tasks.dto.DoctorDto;
import com.example.tasks.entity.Doctor;
import com.example.tasks.mapper.DoctorMapper;
import com.example.tasks.repository.DoctorRepository;
import com.example.tasks.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Transactional
    @Override
    public Doctor register(DoctorDto doctorDto) {
        return Optional.of(doctorDto)
                .map(doctorMapper::toEntity)
                .map(doctorRepository::save)
                .orElseThrow();
    }

    @Override
    public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }

    @Transactional
    @Override
    public Doctor update(Long id, DoctorDto doctorDto) {

        Doctor doctor = doctorMapper.toEntity(doctorDto);
        doctor.setId(id);
        return doctorRepository.save(doctor);
    }
}
