package com.example.smart4aviationtask;

import com.example.smart4aviationtask.application.FlightLuggageWeightDtoConverter;
import com.example.smart4aviationtask.db.FlightRepo;
import com.example.smart4aviationtask.db.FlightRepository;
import com.example.smart4aviationtask.domain.Flight;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

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
        List<Flight> list = new ArrayList<>();
        return new FlightRepo(list);
    }
}
