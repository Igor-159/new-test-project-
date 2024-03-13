package com.example.tasks.dto;

import java.util.List;

public record DoctorResponseDto(
        Long id,
        String name,
        String lastName,
        String profile,
        List<PatientResponseDto> patients
) {
}
