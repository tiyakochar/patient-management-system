package com.mappper;

import com.dto.PatientRequestDto;
import com.dto.PatientResponseDto;
import com.dto.UpdateRequestDto;
import com.model.Patient;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")

public interface PatientMapper {

   public  PatientResponseDto PatienttoPatientResponseDto(Patient patient);
   public Patient PatientRequestDtoToPatient(PatientRequestDto    patientRequestDto);
   public Patient UpdateRequestDtoToPatient(UpdateRequestDto updateRequestDto);
}