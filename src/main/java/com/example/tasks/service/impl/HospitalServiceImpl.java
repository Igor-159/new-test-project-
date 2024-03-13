package com.example.tasks.service.impl;

import com.example.tasks.dto.HospitalDto;
import com.example.tasks.entity.Hospital;
import com.example.tasks.entity.Patient;
import com.example.tasks.mapper.HospitalMapper;
import com.example.tasks.repository.HospitalRepository;
import com.example.tasks.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;
    private final HospitalMapper hospitalMapper;

    @Transactional
    @Override
    public Hospital register(HospitalDto hospitalDto) {
        return Optional.of(hospitalDto)
                .map(hospitalMapper::toEntity)
                .map(hospitalRepository::save)
                .orElseThrow();
    }


    @Override
    public Optional<Hospital> findById(Long id) {
        return hospitalRepository.findById(id);
    }
}
