package com.example.smart4aviationtask.application;

import com.example.smart4aviationtask.application.dto.FlightLuggageWeightDto;
import com.example.smart4aviationtask.domain.Baggage;
import com.example.smart4aviationtask.domain.Cargo;
import com.example.smart4aviationtask.domain.Flight;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FlightLuggageWeightDtoConverterTest {

    @Test
    public void should_convert_flight_entity_to_flight_luggage_weight_dto() {
        //given
        final Flight flight = flightEntityFixture();
        //when
        FlightLuggageWeightDto flightLuggageWeightDto = new FlightLuggageWeightDtoConverter().convert(flight);

        //then
        assertNotNull(flightLuggageWeightDto);
        assertEquals(flightLuggageWeightDto.getBaggageWeight(), 120);
        assertEquals(flightLuggageWeightDto.getCargoWeight(), 60);
        assertEquals(flightLuggageWeightDto.getFullWeight(), 180);
    }

    private Flight flightEntityFixture() {
        final UUID flightId = UUID.randomUUID();
        return new Flight(flightId, 123,
                "KRA", "WAW", Instant.now(), cargoEntityFixture(flightId));
    }

    private Cargo cargoEntityFixture(final UUID flightId) {
        return new Cargo(10L, flightId,
                List.of(new Baggage(0, 20.0, "kg", 3), new Baggage(1, 20.0, "kg", 3)),
                List.of(new Baggage(0, 20.0, "kg", 3)));
    }
}