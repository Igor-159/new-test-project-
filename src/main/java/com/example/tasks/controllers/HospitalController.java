package com.example.tasks.controllers;

import com.example.tasks.dto.HospitalDto;
import com.example.tasks.dto.PatientDto;
import com.example.tasks.entity.Hospital;
import com.example.tasks.entity.Patient;
import com.example.tasks.service.HospitalService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Tag(name = "hospital controller")
@RestController
@RequestMapping(value = "hospitals")
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    @PostMapping
    public ResponseEntity<Hospital> registerPatient(
            @Parameter(in = ParameterIn.DEFAULT,
                    required = true,
                    schema = @Schema())
            @Valid @RequestBody HospitalDto hospitalDto
    ) {

        Hospital hospital = hospitalService.register(hospitalDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(hospital);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospital> getHospitalById(
            @Parameter(in = ParameterIn.PATH,
                    description = "id of hospital",
                    required = true,
                    schema = @Schema())
            @PathVariable Long id
    ) {
        Optional<Hospital> result = hospitalService.findById(id);
        if(result.isPresent()){
            Hospital hospital = result.get();
            return ResponseEntity.status(HttpStatus.OK).body(hospital);
        }else return (ResponseEntity<Hospital>) ResponseEntity.status(HttpStatus.NOT_FOUND);
    }
}
