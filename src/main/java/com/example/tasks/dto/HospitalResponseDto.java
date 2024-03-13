package com.example.tasks.dto;

import java.util.List;

public record HospitalResponseDto(
        Long id,
        String name,
        String address,
        List<DoctorDto> doctors
) {
}
