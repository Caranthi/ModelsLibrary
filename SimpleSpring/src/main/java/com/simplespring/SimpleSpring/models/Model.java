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
    private final String species = "Bowhead whale";
    @Column
    private final String colour = "Black";
    @Column
    private final String firstAppearance = "2023-06";
    @Column
    private final int weight = 300;




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
