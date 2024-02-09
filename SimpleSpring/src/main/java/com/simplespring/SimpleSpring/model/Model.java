package com.simplespring.SimpleSpring.model;

import jakarta.persistence.*;

@Entity // entities are objects stored in a database
@Table(name = "Models") // otherwise the name of the table is the name of the file
public class Model {

    @Id // primary key
    @GeneratedValue // an id automatically generated
    @Column
    private int id;
    @Column // column name the same as field by default
    private String species = "b";
    @Column
    private String colour = "b";
    @Column
    private String firstAppearance = "b";
    @Column
    private int weight = 3;

    public Model() {
        super();
    } // a default constructor is still needed for some reason

    public Model(String species, String colour, String firstAppearance, int weight) {
        this.species = species;
        this.colour = colour;
        this.firstAppearance = firstAppearance;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getSpecies() {
        return species;
    }

    public String getColour() {
        return colour;
    }

    public String getFirstAppearance() {
        return firstAppearance;
    }

    public int getWeight() {
        return weight;
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

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setFirstAppearance(String firstAppearance) {
        this.firstAppearance = firstAppearance;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
