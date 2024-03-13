package com.example.tasks.dto;

import com.example.tasks.entity.Doctor;
import com.example.tasks.entity.Hospital;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PatientDto(
        @JsonProperty("patient_name")
        @NotBlank
        String name,
        @JsonProperty("last_name")
        @NotBlank
        String lastName,
        @JsonProperty("patient_age")
        Integer age,
        @JsonProperty("doctor_id")
        List<DoctorDto> doctors,
        @JsonProperty("hospital_id")
        HospitalDto hospital
) {
}
