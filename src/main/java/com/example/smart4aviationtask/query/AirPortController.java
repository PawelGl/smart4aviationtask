package com.example.smart4aviationtask.query;

import com.example.smart4aviationtask.application.FlightService;
import com.example.smart4aviationtask.application.PlanesForAirportNotFoundException;
import com.example.smart4aviationtask.application.dto.PlanesInformationForAirportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("airport")
@RequiredArgsConstructor
public class AirPortController {
    private final FlightService flightService;

    @GetMapping(path = "/planesInformation")
    @ResponseBody
    ResponseEntity<PlanesInformationForAirportDto> getPlanesInformationForAirport(@RequestParam("airportIATACode") final String airportIATACode) throws PlanesForAirportNotFoundException {
        PlanesInformationForAirportDto informationAboutPlanesForAirport = flightService.findInformationAboutPlanesForAirport(airportIATACode);
        return ResponseEntity.ok().body(informationAboutPlanesForAirport);
    }
}
