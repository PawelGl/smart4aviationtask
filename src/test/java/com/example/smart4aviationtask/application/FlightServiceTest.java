package com.example.smart4aviationtask.application;

import com.example.smart4aviationtask.application.dto.FlightLuggageWeightDto;
import com.example.smart4aviationtask.application.dto.PlanesInformationForAirportDto;
import com.example.smart4aviationtask.db.FlightRepository;
import com.example.smart4aviationtask.domain.Baggage;
import com.example.smart4aviationtask.domain.Cargo;
import com.example.smart4aviationtask.domain.Flight;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FlightServiceTest {

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightService flightService;


    @Test
    public void should_find_flight_luggage_weight() throws FlightNotFoundException {
        //given
        when(flightRepository.findByFlightNumberAndDepartureDate(anyInt(), any()))
                .thenReturn(flightEntityFixture("KRA", "KRA"));

        //when
        FlightLuggageWeightDto flightLuggageWeight = flightService.findFlightLuggageWeight(123, Date.from(Instant.now()));

        //then
        assertFlightLuggageWeightDto(flightLuggageWeight, flightLuggageWeightDtoExpectedFixture());
    }

    @Test
    public void should_find_information_about_planes_for_airport() throws PlanesForAirportNotFoundException {
        //given
        when(flightRepository.findAllByDepartureAirportIATACodeOrArrivalAirportIATACode(any(), any()))
                .thenReturn(List.of(flightEntityFixture("KRA", "WRA"),
                        flightEntityFixture("WRA", "KRA")));

        //when
        PlanesInformationForAirportDto informationAboutPlanesForAirport = flightService.findInformationAboutPlanesForAirport("KRA");

        //then
        assertPlanesInformationForAirportDto(informationAboutPlanesForAirport, planesInformationForAirportDtoExpectedFixture());
    }

    private void assertFlightLuggageWeightDto(FlightLuggageWeightDto flightLuggageWeight, FlightLuggageWeightDto flightLuggageWeightExpected) {
        Assertions.assertThat(flightLuggageWeight.getFullWeight()).isEqualTo(flightLuggageWeightExpected.getFullWeight());
        Assertions.assertThat(flightLuggageWeight.getCargoWeight()).isEqualTo(flightLuggageWeightExpected.getCargoWeight());
        Assertions.assertThat(flightLuggageWeight.getBaggageWeight()).isEqualTo(flightLuggageWeightExpected.getBaggageWeight());
    }

    private void assertPlanesInformationForAirportDto(PlanesInformationForAirportDto planesInformationForAirportDto, PlanesInformationForAirportDto planesInformationForAirportDtoExpected) {
        Assertions.assertThat(planesInformationForAirportDto.getNumberOfFlightsArrivingToAirport()).isEqualTo(planesInformationForAirportDtoExpected.getNumberOfFlightsArrivingToAirport());
        Assertions.assertThat(planesInformationForAirportDto.getTotalNumberOfBaggageArrivingToAirport()).isEqualTo(planesInformationForAirportDtoExpected.getTotalNumberOfBaggageArrivingToAirport());
        Assertions.assertThat(planesInformationForAirportDto.getNumberOfFlightsDepartingFromAirport()).isEqualTo(planesInformationForAirportDto.getNumberOfFlightsDepartingFromAirport());
        Assertions.assertThat(planesInformationForAirportDto.getTotalNumberOfBaggageDepartingFromAirport()).isEqualTo(planesInformationForAirportDto.getTotalNumberOfBaggageDepartingFromAirport());
    }

    private Flight flightEntityFixture(final String departureAirportIATACode, final String arrivalAirportIATACode) {
        final UUID flightId = UUID.randomUUID();
        return new Flight(flightId, 123,
                departureAirportIATACode, arrivalAirportIATACode, Instant.now(), cargoEntityFixture(flightId));
    }

    private Cargo cargoEntityFixture(final UUID flightId) {
        return new Cargo(flightId,
                List.of(new Baggage(0, 20.0, "kg", 3), new Baggage(1, 20.0, "kg", 3)),
                List.of(new Baggage(0, 20.0, "kg", 3)));
    }

    private FlightLuggageWeightDto flightLuggageWeightDtoExpectedFixture() {
        return new FlightLuggageWeightDto(60, 120);
    }

    private PlanesInformationForAirportDto planesInformationForAirportDtoExpectedFixture() {
        return new PlanesInformationForAirportDto(1, 1, 6, 6);
    }
}