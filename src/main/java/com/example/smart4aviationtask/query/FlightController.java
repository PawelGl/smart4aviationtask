package com.example.smart4aviationtask.query;

import com.example.smart4aviationtask.application.FlightNotFoundException;
import com.example.smart4aviationtask.application.FlightService;
import com.example.smart4aviationtask.application.dto.FlightLuggageWeightDto;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("flight")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @GetMapping(path = "/flightLuggageWeight")
    ResponseEntity<FlightLuggageWeightDto> findFlightLuggageWeight(@RequestParam("flightNumber") final int flightNumber,
                                                                   @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") final Date date) throws FlightNotFoundException {
        return ResponseEntity.ok(flightService.findFlightLuggageWeight(flightNumber, date));
    }
}
