package com.example.first.dao;

import java.util.UUID;
import java.util.List;
import java.util.Optional;
import com.example.first.model.Person;

public interface PersonDao {
    // INSERT
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
