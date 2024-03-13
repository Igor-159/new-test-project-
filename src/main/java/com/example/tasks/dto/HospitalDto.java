package com.example.tasks.dto;

import com.example.tasks.entity.Doctor;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record HospitalDto(
        @JsonProperty("hospital_name")
        @NotBlank
        String name,
        @JsonProperty("address")
        @NotBlank
        String address,
        @JsonProperty("doctor_id")
        List<DoctorDto> doctors
) {
}
