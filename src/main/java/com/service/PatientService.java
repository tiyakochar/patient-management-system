package com.service;

import com.dto.PatientRequestDto;
import com.dto.PatientResponseDto;
import com.dto.UpdateRequestDto;
import com.exceptions.PatientAlreadyExistByEmail;
import com.exceptions.PatientNotFound;
import com.mappper.PatientMapper;
import com.model.Patient;
import com.repository.PatientRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PatientService {
    @Autowired
    private final PatientRepository patientRepository;
    @Autowired
    public PatientMapper mapper;
    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);
    public PatientService(PatientRepository patientRepository, PatientMapper mapper) {
        this.patientRepository = patientRepository;
        this.mapper = mapper;
    }

    public List<PatientResponseDto> getAllPatients() {

        List<Patient> p = patientRepository.findAll();
        System.out.println(p+"from find ALL");
        List<PatientResponseDto> patient_response_list = p.stream().map(patient -> mapper.PatienttoPatientResponseDto(patient)).toList();
        System.out.println(patient_response_list+"from service");
        return patient_response_list;
    }

    public UUID createPatient(PatientRequestDto patientRequestDto ) {
        logger.warn("Patient already exists by this email : {}", patientRequestDto.getEmail());
        if(patientRepository.existsByEmail(patientRequestDto.getEmail())){
            throw new PatientAlreadyExistByEmail();
        }
        Patient p = patientRepository.save(mapper.PatientRequestDtoToPatient(patientRequestDto));
        return p.getId();
    }

    public String updatePatient(UpdateRequestDto updateRequestDto) {
        Optional<Patient> patient = patientRepository.findById(updateRequestDto.getId());


        if (!patient.isPresent()) {
            logger.warn("Patient not found with id: {}", updateRequestDto.getId());
            throw new PatientNotFound("Patient not found with id: " + updateRequestDto.getId());
        } else if (patientRepository.existsByEmail(updateRequestDto.getEmail())) {
            logger.warn("Patient already exists by this email : {}", updateRequestDto.getEmail());
            logger.warn("Duplicate Email :{}", updateRequestDto.getEmail());
            throw new PatientAlreadyExistByEmail();
        } else {

                if (updateRequestDto.getName() == null|| updateRequestDto.getName()== "") {
                    System.out.println("Inside service method update patient name is null"+updateRequestDto.getName());
                    updateRequestDto.setName(patient.get().getName());
                    System.out.println(updateRequestDto.getName()+"Inside service method update patient name ");
                } else if (updateRequestDto.getEmail() == null || updateRequestDto.getEmail()== "") {
                    System.out.println("Inside service method update patient email is null"+updateRequestDto.getEmail());
                    updateRequestDto.setEmail(patient.get().getEmail());
                } else if (updateRequestDto.getAddress() == null || updateRequestDto.getAddress()== "") {
                    System.out.println("Inside service method update patient address is null"+updateRequestDto.getAddress());
                    updateRequestDto.setAddress(patient.get().getAddress());
                }
                Patient p = patientRepository.save(mapper.UpdateRequestDtoToPatient(updateRequestDto));
                return p.getId().toString();

        }
    }
    public void deletePatient(UUID id) {
        boolean b = patientRepository.existsById(id);
        if(!b){
            logger.warn("Patient not found with id: {}", id);
            throw new PatientNotFound("Patient not found with id: " +id);
        }
        else
        {
            patientRepository.deleteById(id);
        }

    }
}