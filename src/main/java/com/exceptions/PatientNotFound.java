package com.exceptions;

public class PatientNotFound extends RuntimeException{
    public PatientNotFound(String s) {
        super("Patient not found");
    }
}
