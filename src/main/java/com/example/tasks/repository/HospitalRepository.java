package com.example.tasks.repository;

import com.example.tasks.entity.Hospital;
import com.example.tasks.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
