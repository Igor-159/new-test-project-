package com.example.tasks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PatientResponseDto(
        Long id,
        String name,
        @JsonProperty("last_name")
        String lastName,
        Integer age,
        DoctorDto doctor,
        HospitalDto hospital
) {
}
