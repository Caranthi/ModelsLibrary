package com.simplespring.SimpleSpring.models;

import java.time.LocalDate;

public class Model {
    private String species;
    private String colour;
    private LocalDate firstAppearance;
    private int weight;

    public Model(String species, String colour, LocalDate firstAppearance, int weight) {
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
