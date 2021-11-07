package com.example.first.v1.dao;

import java.util.UUID;

import com.example.first.v1.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDao {
    // INSERT
    // METHOD OVFERLOADING
    int insertPerson(UUID id, Person person);
    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    // FETCH ALL THE USERS
    List<Person> selectAllPeople();

    // FETCH BY ID
    Optional<Person> selectPeopleById(UUID id);

    // DELETE
    int deletePersonById(UUID id);

    // UPDATE
    int updatePersonById(UUID id, Person person);
}
