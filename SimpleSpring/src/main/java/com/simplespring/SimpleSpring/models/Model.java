package com.simplespring.SimpleSpring.models;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.time.LocalDate;

@Entity // entities are objects stored in a databse
@Table(name = "Models") // otherwise the name of the table is the name of the file

public class Model {

    @Id // primary key
    @GeneratedValue // an id automatically generated
    private int id;
    @Column // column name the same as filed by default
    private final String species;
    @Column
    private final String colour;
    @Column
    private final LocalDate firstAppearance;
    @Column
    private final int weight;

    public Model(String species, String colour, LocalDate firstAppearance, int weight) { // mind that no id is needed here
        this.species = species;
        this.colour = colour;
        this.firstAppearance = firstAppearance;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Model{" +
                "species='" + species + '\'' +
                ", colour='" + colour + '\'' +
                ", firstAppearance=" + firstAppearance +
                ", weight=" + weight +
                '}';
    }
}
