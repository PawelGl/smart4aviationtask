package com.example.smart4aviationtask.application;


import com.example.smart4aviationtask.db.FlightRepo;
import com.example.smart4aviationtask.domain.Baggage;
import com.example.smart4aviationtask.domain.Cargo;
import com.example.smart4aviationtask.domain.Flight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;
import java.util.UUID;


class FlightRepoTest {

    private static List<Flight> FLIGHT_ENTITY_LIST;

    @Test
    public void should_return_planes_with_correct_arrivalAirport_or_departureAirport() {
        //given
        FLIGHT_ENTITY_LIST = List.of(flightEntityFixture("KRA", "WAW"),
                flightEntityFixture("CWA", "KRA"),
                flightEntityFixture("WAW", "KRA"),
                flightEntityFixture("CWA", "WRA"));

        //when
        List<Flight> kraPlanes = new FlightRepo(FLIGHT_ENTITY_LIST).findAllByDepartureAirportIATACodeOrArrivalAirportIATACode("KRA");

        //then
        Assertions.assertNotNull(kraPlanes);
        Assertions.assertEquals(3, kraPlanes.size());
    }


    private Flight flightEntityFixture(final String departureAirportIATACode, final String arrivalAirportIATACode) {
        return new Flight(UUID.randomUUID(), 123,
                departureAirportIATACode, arrivalAirportIATACode, Instant.now(), cargoEntityFixture());
    }

    private Cargo cargoEntityFixture() {
        return new Cargo(10L, 123,
                List.of(new Baggage(0, 20.0, "kg", 3), new Baggage(1, 20.0, "kg", 3)),
                List.of(new Baggage(0, 20.0, "kg", 3)));
    }
}