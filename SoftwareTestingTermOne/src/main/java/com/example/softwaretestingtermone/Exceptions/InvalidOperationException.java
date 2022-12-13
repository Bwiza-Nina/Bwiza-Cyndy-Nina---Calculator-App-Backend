package com.example.softwaretestingtermone.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidOperationException extends RuntimeException{

    private static final long UID = 1L;
    public InvalidOperationException(String message){ super(message);}
}
