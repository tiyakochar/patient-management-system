package com.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public class PatientRequestDto {

    @NotNull(message = "Name cannot be null")
    String name;

    @NotNull(message = "Address cannot be null")
    String address;
    @NotNull(message = "Email cannot be null")
    String email;
    public @NotNull(message = "Date of Birth cannot be null")
    LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    @NotNull(message = "Date of Birth cannot be null")
    LocalDate dob;
    @NotNull(message = "Registered Date cannot be null")
    LocalDate registeredDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }




}
