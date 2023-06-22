package com.simplespring.SimpleSpring.models;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.time.LocalDate;

@Entity // entities are objects stored in a database
@Table(name = "Models") // otherwise the name of the table is the name of the file

public class Model {

    @Id // primary key
    @GeneratedValue // an id automatically generated
    @Column
    private int id;
    @Column // column name the same as filed by default
    private String species = "b";
    @Column
    private String colour = "b";
    @Column
    private String firstAppearance = "b";
    @Column
    private int weight = 3;

    public Model()
    {
        super();
    }

    public Model(String species, String colour, String firstAppearance, int weight) {
        this.species = species;
        this.colour = colour;
        this.firstAppearance = firstAppearance;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id='" + id + '\'' +
                "species='" + species + '\'' +
                ", colour='" + colour + '\'' +
                ", firstAppearance=" + firstAppearance +
                ", weight=" + weight +
                '}';
    }
}
