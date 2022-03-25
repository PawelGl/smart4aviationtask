package com.example.smart4aviationtask.application;

public class FlightNotFoundException extends Exception{
    private final String message;

    FlightNotFoundException(final String message){
        this.message = message;
    }
}
