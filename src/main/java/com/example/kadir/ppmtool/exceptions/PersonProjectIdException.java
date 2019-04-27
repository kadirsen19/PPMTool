package com.example.kadir.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PersonProjectIdException extends RuntimeException{

    public PersonProjectIdException(String message) {
        super(message);
    }
}
