package com.onuryilmazer.springpetclinic.model;

public class VetSpecialty extends BaseEntity {
    private String specialtyName;

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }
}
