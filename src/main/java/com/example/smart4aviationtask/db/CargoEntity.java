package com.example.smart4aviationtask.db;

import com.example.smart4aviationtask.domain.Baggage;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class CargoEntity {

    @Id
    private int flightId;
    @Embedded
    private List<Baggage> baggage;
    @Embedded
    private List<Baggage> cargo;
}
