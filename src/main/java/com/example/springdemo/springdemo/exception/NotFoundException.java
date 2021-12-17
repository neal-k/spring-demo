package com.example.springdemo.springdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author neal.khatiwada
 * @created 12/17/21
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super("Could not find data");
    }
}
