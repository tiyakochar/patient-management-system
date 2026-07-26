package com.repository;

import com.model.Patient;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Id> {
}
