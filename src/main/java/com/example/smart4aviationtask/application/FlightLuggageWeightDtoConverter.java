package com.example.smart4aviationtask.application;

import com.example.smart4aviationtask.application.dto.FlightLuggageWeightDto;
import com.example.smart4aviationtask.domain.Flight;

public class FlightLuggageWeightDtoConverter {

   FlightLuggageWeightDto convert(final Flight flight) {
        return new FlightLuggageWeightDto(flight.getCargo().getFullCargoWeight(),
                flight.getCargo().getFullBaggageWeight());
    }
}
