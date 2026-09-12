package com.exceptions;

public class PatientAlreadyExistByEmail extends RuntimeException{
    public PatientAlreadyExistByEmail() {
        super("Patient already exist by email");
    }
}
