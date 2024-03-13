package com.example.tasks.controllers;

import com.example.tasks.dto.PatientDto;
import com.example.tasks.entity.Patient;
import com.example.tasks.service.PatientService;
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

@Tag(name = "patient controller")
@RestController
@RequestMapping(value = "patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> registerPatient(
            @Parameter(in = ParameterIn.DEFAULT,
                    required = true,
                    schema = @Schema())
            @Valid @RequestBody PatientDto patientDto
    ) {

        Patient patient = patientService.register(patientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(patient);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Patient> getDoctorById(
            @Parameter(in = ParameterIn.PATH,
                    description = "id of patient",
                    required = true,
                    schema = @Schema())
            @PathVariable("patientId") Long id
    ) {
        Optional<Patient> result = patientService.findById(id);
        if(result.isPresent()){
            Patient patient = result.get();
            return ResponseEntity.status(HttpStatus.OK).body(patient);
        }else return (ResponseEntity<Patient>) ResponseEntity.status(HttpStatus.NOT_FOUND);
    }
}
