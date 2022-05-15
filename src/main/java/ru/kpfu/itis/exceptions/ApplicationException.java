package ru.kpfu.itis.exceptions;

public class ApplicationException extends RuntimeException {

    public ApplicationException(String message){
        super(message);
    }
}
