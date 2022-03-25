package com.example.smart4aviationtask.db;

import com.example.smart4aviationtask.domain.Baggage;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class CargoEntity {

    private long id;
    private int flightId;
    private List<Baggage> baggage;
    private List<Baggage> cargo;
}
