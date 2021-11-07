package com.example.first.v1.model;

import java.util.UUID;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    private final UUID id;
    @NotBlank
    private final String name;

    // CONSTRUCTOR
    public Person(@JsonProperty("id") UUID id,@JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    // GETTERS
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
