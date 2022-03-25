package com.example.smart4aviationtask.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PlanesInformationForAirportDto {
    private final int numberOfFlightsDepartingFromAirport;
    private final int numberOfFlightsArrivingToAirport;
    private final int totalNumberOfBaggageDepartingFromAirport;
    private final int totalNumberOfBaggageArrivingToAirport;


}
