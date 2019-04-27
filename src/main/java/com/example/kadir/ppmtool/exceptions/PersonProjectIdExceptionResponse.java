package com.example.kadir.ppmtool.exceptions;

public class PersonProjectIdExceptionResponse {

    private String personProjectIdentifier;

    public PersonProjectIdExceptionResponse(String personProjectIdentifier) {
        this.personProjectIdentifier = personProjectIdentifier;
    }

    public String getPersonProjectIdentifier() {
        return personProjectIdentifier;
    }

    public void setPersonProjectIdentifier(String personProjectIdentifier) {
        this.personProjectIdentifier = personProjectIdentifier;
    }
}
