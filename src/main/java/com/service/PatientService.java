package com.service;

import aj.org.objectweb.asm.commons.InstructionAdapter;
import com.dto.PatientResponseDto;
import com.mappper.PatientMapper;
import com.model.Patient;
import com.repository.PatientRepository;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PatientService {
    private  final PatientRepository patientRepository;
    public PatientMapper mapper;
public PatientService(PatientRepository patientRepository, PatientMapper mapper){
    this.patientRepository=patientRepository;
    this.mapper=mapper;
}

    public List<PatientResponseDto> getAllPatients(){

     List<Patient> p= patientRepository.findAll();
List<PatientResponseDto> patient_response_list=p.stream().map(patient->mapper.PatienttoPatientResponseDto(patient)).toList();
    return  patient_response_list;
    }
}
