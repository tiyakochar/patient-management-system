package com.controller;

import com.dto.PatientRequestDto;
import com.dto.PatientResponseDto;
import com.dto.UpdateRequestDto;
import com.model.Patient;
import com.service.PatientService;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/patient")
public class PatientController {


    @Autowired
    private  final PatientService patientService;


    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/allpatients")
    public ResponseEntity<List<PatientResponseDto>> getAllPatients() {

        List<PatientResponseDto> patients = patientService.getAllPatients();
        System.out.println(patients);
        return ResponseEntity.ok().body(patients);
    }
    @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody PatientRequestDto patientRequestDto) {
        System.out.println(patientRequestDto.getAddress()+"from controller");
        UUID patientId = patientService.createPatient(patientRequestDto);
        return ResponseEntity.ok("Patient created with ID: " + patientId);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updatePatient(@Valid @RequestBody UpdateRequestDto patientRequestDto) {
        // Implement the update logic here

        System.out.println("inside controller update method");
      String patient_status=  patientService.updatePatient(patientRequestDto);
        return ResponseEntity.ok("Patient updated with ID: " + patient_status.toString());

    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePatient(@RequestParam UUID id) {
        // Implement the delete logic here
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient deleted with ID: " + id.toString());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<PatientResponseDto>getPatientById(@PathVariable UUID id){


        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
    @DeleteMapping("/delete{id}")
    public ResponseEntity<String> deletePatientById(@PathVariable UUID id) {

        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient deleted with ID: " + id.toString());

    }
    @PutMapping("/Update/{id}")
    public ResponseEntity<String> updatePatientById(@PathVariable UUID id, @RequestBody UpdateRequestDto updateRequestDto) {
        // Implement the update logic here

        String patient_status=  patientService.updatePatient(updateRequestDto);
        return ResponseEntity.ok("Patient updated with ID: " + patient_status.toString());
    }
}
