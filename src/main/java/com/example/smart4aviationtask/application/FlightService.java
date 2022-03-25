package com.example.smart4aviationtask.application;

import com.example.smart4aviationtask.application.dto.FlightLuggageWeightDto;
import com.example.smart4aviationtask.application.dto.PlanesInformationForAirportDto;
import com.example.smart4aviationtask.db.FlightRepository;
import com.example.smart4aviationtask.domain.Flight;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightService {
    private static final FlightLuggageWeightDtoConverter flightLuggageWeightDtoConverter = new FlightLuggageWeightDtoConverter();
    private final FlightRepository flightRepository;

    public FlightLuggageWeightDto findFlightLuggageWeight(final int flightNumber, final Date date)
            throws FlightNotFoundException {
        final Flight byFlightNumberAndDepartureDate =
                Optional.ofNullable(flightRepository.findByFlightNumberAndDepartureDate(flightNumber, date))
                        .orElseThrow(() ->
                                new FlightNotFoundException("Flight with number" + flightNumber + " and departure date  " + date + " not found."));
        return flightLuggageWeightDtoConverter.convert(byFlightNumberAndDepartureDate);
    }

    public PlanesInformationForAirportDto findInformationAboutPlanesForAirport(final String airportIATACode) throws PlanesForAirportNotFoundException {
        final List<Flight> flightEntities = Optional.ofNullable(flightRepository.findAllByDepartureAirportIATACodeOrArrivalAirportIATACode(airportIATACode, airportIATACode))
                .orElseThrow(() -> new PlanesForAirportNotFoundException("Flights for airportIATACode: " + airportIATACode + " not found."));
        final List<Flight> planesDepartingFromAirport = getPlanesDepartingFromAirport(airportIATACode, flightEntities);
        final List<Flight> planesArrivingToAirport = getPlanesArrivingToAirport(airportIATACode, flightEntities);
        return new PlanesInformationForAirportDto(planesDepartingFromAirport.size(), planesArrivingToAirport.size(),
                getAllPiecesOfBaggageForPlanes(planesDepartingFromAirport), getAllPiecesOfBaggageForPlanes(planesArrivingToAirport));
    }

    private List<Flight> getPlanesDepartingFromAirport(final String airportIATACode, final List<Flight> flightEntities) {
        return flightEntities.stream().filter(flightEntity -> flightEntity.getDepartureAirportIATACode().equals(airportIATACode))
                .collect(Collectors.toList());
    }

    private List<Flight> getPlanesArrivingToAirport(final String airportIATACode, final List<Flight> flightEntities) {
        return flightEntities.stream().filter(flightEntity -> flightEntity.getArrivalAirportIATACode().equals(airportIATACode))
                .collect(Collectors.toList());
    }

    private int getAllPiecesOfBaggageForPlanes(final List<Flight> flightEntities) {
        return flightEntities.stream().reduce(0, (pieces, flight) -> pieces + flight.getAllBaggagePieces(), Integer::sum);
    }
}
