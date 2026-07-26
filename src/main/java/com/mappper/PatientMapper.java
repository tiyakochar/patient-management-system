package com.mappper;

import com.dto.PatientResponseDto;
import com.model.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

   public  PatientResponseDto PatienttoPatientResponseDto(Patient patient);
   public Patient PatientResponseDtoToPatient(PatientResponseDto patientResponseDto);

}