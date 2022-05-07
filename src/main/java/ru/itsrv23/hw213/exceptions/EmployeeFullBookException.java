package ru.itsrv23.hw213.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeFullBookException extends RuntimeException{
    public EmployeeFullBookException() {
    }
}
