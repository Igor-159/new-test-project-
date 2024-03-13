package com.example.tasks.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(exclude = {"doctors"}, callSuper = true)
@ToString(exclude = {"doctors"}, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "hospitals")
public class Hospital extends BaseEntity {

    @NotBlank
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @NotBlank
    @Column
    private String address;


    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Doctor> doctors = new ArrayList<>();

}


