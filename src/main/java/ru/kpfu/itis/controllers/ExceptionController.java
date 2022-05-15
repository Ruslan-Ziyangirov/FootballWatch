package ru.kpfu.itis.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.kpfu.itis.exceptions.ApplicationException;

import java.util.logging.Logger;

@ControllerAdvice
public class ExceptionController {

    private final Logger log = Logger.getLogger(ExceptionController.class.getName());

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String postException() {
        return "exception";
    }

    @ExceptionHandler(RuntimeException.class)
    public void postRuntimeException(ApplicationException exception) {
        log.info(exception.toString());
        log.info(exception.getMessage());
    }

}
