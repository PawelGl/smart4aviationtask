package com.example.smart4aviationtask.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface FlightEntityRepository extends JpaRepository<FlightEntity, UUID> {

    FlightEntity findByFlightNumberAndDepartureDate(final int flightNumber, final Date date);

    List<FlightEntity> findAllByDepartureAirportIATACodeOrArrivalAirportIATACode(final String departureAirportIATACode, final String arrivalAirportIATACode);

}
