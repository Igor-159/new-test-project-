package com.example.tasks.controllers;

import com.example.tasks.dto.DoctorDto;
import com.example.tasks.entity.Doctor;
import com.example.tasks.service.DoctorService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;


@Tag(name = "doctor controller")
@RestController
@RequestMapping(value = "doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
        public ResponseEntity<Doctor> registerDoctor(
            @Parameter(in = ParameterIn.DEFAULT,
                    required = true,
                    schema = @Schema())
            @Valid @RequestBody DoctorDto doctorDto
    ) {

        Doctor doctor = doctorService.register(doctorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
    }

    @GetMapping("/{id}")
        public ResponseEntity<Doctor> getDoctorById(
            @Parameter(in = ParameterIn.PATH,
                    description = "id of doctor",
                    required = true,
                    schema = @Schema())
            @PathVariable Long id
    ) {

        return ResponseEntity.of(doctorService.findById(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(
            @PathVariable Long id,
            @RequestBody DoctorDto dto
    ) {
        Doctor doctor = doctorService.update(id, dto);
        return doctor != null ? new ResponseEntity<>(HttpStatus.OK)
                              : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
