package com.mappper;

import com.dto.PatientRequestDto;
import com.dto.PatientResponseDto;
import com.dto.UpdateRequestDto;
import com.model.Patient;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-10T20:39:31+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.12 (Oracle Corporation)"
)
@Component
public class PatientMapperImpl implements PatientMapper {

    @Override
    public PatientResponseDto PatienttoPatientResponseDto(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientResponseDto patientResponseDto = new PatientResponseDto();

        patientResponseDto.setName( patient.getName() );
        if ( patient.getId() != null ) {
            patientResponseDto.setId( patient.getId().toString() );
        }
        patientResponseDto.setAddress( patient.getAddress() );
        patientResponseDto.setEmail( patient.getEmail() );

        return patientResponseDto;
    }

    @Override
    public Patient PatientRequestDtoToPatient(PatientRequestDto patientRequestDto) {
        if ( patientRequestDto == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setName( patientRequestDto.getName() );
        patient.setEmail( patientRequestDto.getEmail() );
        patient.setDob( patientRequestDto.getDob() );
        patient.setRegisteredDate( patientRequestDto.getRegisteredDate() );
        patient.setAddress( patientRequestDto.getAddress() );

        return patient;
    }

    @Override
    public Patient UpdateRequestDtoToPatient(UpdateRequestDto updateRequestDto) {
        if ( updateRequestDto == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setName( updateRequestDto.getName() );
        patient.setId( updateRequestDto.getId() );
        patient.setEmail( updateRequestDto.getEmail() );
        patient.setAddress( updateRequestDto.getAddress() );

        return patient;
    }
}
