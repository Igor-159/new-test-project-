package com.example.tasks.dto;

import com.example.tasks.entity.Hospital;
import com.example.tasks.entity.Patient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DoctorDto(
        @JsonProperty("doctor_name")
        @NotBlank
        String name,
        @JsonProperty("last_name")
        @NotBlank
        String lastName,
        @NotBlank
        String profile,
        @JsonProperty("patients")
        List<PatientDto> patients,
        @JsonProperty("hospital_id")
        HospitalDto hospital
) {
}
