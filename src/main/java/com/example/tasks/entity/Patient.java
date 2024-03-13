package com.example.tasks.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;


@EqualsAndHashCode(exclude = {"doctors", "hospital"}, callSuper = true)
@ToString(exclude = {"doctors", "hospital"}, callSuper = true)
@NoArgsConstructor
@Data
@Entity
@Table(name = "patients")
public class Patient extends BaseEntity{

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "age")
    private Integer age;

    @ManyToMany(mappedBy = "patients", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Doctor> doctors;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

}
