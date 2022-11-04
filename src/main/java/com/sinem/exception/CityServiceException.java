package com.sinem.exception;

import lombok.Getter;

@Getter
public class CityServiceException extends RuntimeException{
    private final ErrorType errorType;

    public CityServiceException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public CityServiceException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }
}
