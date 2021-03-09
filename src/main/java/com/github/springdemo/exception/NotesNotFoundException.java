package com.github.springdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotesNotFoundException extends RuntimeException {
    private final String fieldName;
    private final Object fieldValue;

    public NotesNotFoundException(String fieldName, Object fieldValue) {
        super(String.format("Notes not found with %s : '%s'", fieldName, fieldValue));
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
