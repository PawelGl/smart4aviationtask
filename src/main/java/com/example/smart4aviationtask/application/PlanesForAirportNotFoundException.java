package com.example.smart4aviationtask.application;

public class PlanesForAirportNotFoundException extends Exception {
    private final String message;

    PlanesForAirportNotFoundException(final String message) {
        this.message = message;
    }
}
