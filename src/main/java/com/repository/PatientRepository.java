package com.repository;

import com.model.Patient;

import jakarta.persistence.Id;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
   public boolean existsByEmail(String email);
   public boolean existsById(UUID Id);
   public String findEmailById(UUID Id);
}
