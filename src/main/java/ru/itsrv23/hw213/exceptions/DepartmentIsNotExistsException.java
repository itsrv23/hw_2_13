package ru.itsrv23.hw213.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepartmentIsNotExistsException extends RuntimeException{
}
