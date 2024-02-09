package com.simplespring.SimpleSpring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // entities are objects stored in a database
@Table(name = "Models") // otherwise the name of the table is the name of the file
@NoArgsConstructor
@Getter
@Setter
public class Model {

    @Id // primary key
    @GeneratedValue // an id automatically generated
    @Column
    private int id;
    @Column // column name the same as field by default
    private String species;
    @Column
    private String colour;
    @Column
    private int firstAppearance;
    @Column
    private int weight;

    public Model(String species, String colour, int firstAppearance, int weight) {
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
