package com.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;
public class UpdateRequestDto {

@Id
@NotNull
public UUID Id;
    public String name;
    public String address;
    public String email;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return Id;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
