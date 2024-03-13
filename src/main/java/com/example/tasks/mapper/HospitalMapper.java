package com.example.tasks.mapper;

import com.example.tasks.dto.HospitalDto;
import com.example.tasks.dto.HospitalResponseDto;
import com.example.tasks.entity.Hospital;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface HospitalMapper {


    Hospital toEntity(HospitalDto hospitalDto);

//    HospitalResponseDto toRequestDto(Hospital entity);
}
