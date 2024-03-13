package com.example.tasks.mapper;

import com.example.tasks.dto.DoctorDto;
import com.example.tasks.dto.DoctorResponseDto;
import com.example.tasks.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DoctorMapper {


    Doctor toEntity(DoctorDto doctorDto);

//    DoctorResponseDto toRequestDto(Doctor entity);

}
