package com.example.smart4aviationtask;

import com.example.smart4aviationtask.application.FlightLuggageWeightDtoConverter;
import com.example.smart4aviationtask.db.FlightRepo;
import com.example.smart4aviationtask.db.FlightRepository;
import com.example.smart4aviationtask.domain.Baggage;
import com.example.smart4aviationtask.domain.Cargo;
import com.example.smart4aviationtask.domain.Flight;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class Smart4aviationtaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Smart4aviationtaskApplication.class, args);
    }

    @Bean
    FlightLuggageWeightDtoConverter flightLuggageWeightDtoConverter() {
        return new FlightLuggageWeightDtoConverter();
    }

    @Bean
    FlightRepository flightRepository() {
        List<Flight> list = List.of(flightEntityFixture());
        return new FlightRepo(list);
    }

    private Flight flightEntityFixture() {
        return new Flight(UUID.randomUUID(), 123,
                "KRA", "WAW", Instant.now(), cargoEntityFixture());
    }

    private Cargo cargoEntityFixture() {
        return new Cargo(10L, 123,
                List.of(new Baggage(0, 20.0, "kg", 3), new Baggage(1, 20.0, "kg", 3)),
                List.of(new Baggage(0, 20.0, "kg", 3)));
    }
}
