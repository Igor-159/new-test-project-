package com.example.tasks.mapper;

import com.example.tasks.dto.PatientDto;
import com.example.tasks.dto.PatientResponseDto;
import com.example.tasks.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PatientMapper {


    Patient toEntity(PatientDto patientDto);

//    PatientResponseDto toRequestDto(Patient entity);
}
