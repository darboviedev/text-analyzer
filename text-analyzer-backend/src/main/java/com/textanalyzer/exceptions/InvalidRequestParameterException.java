package com.textanalyzer.exceptions;


public class InvalidRequestParameterException extends RuntimeException{

    public InvalidRequestParameterException(String message) {
        super(message);
    }

}
