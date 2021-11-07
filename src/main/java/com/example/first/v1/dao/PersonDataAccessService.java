package com.example.first.v1.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.first.v1.model.Person;

import org.springframework.stereotype.Repository;

@Repository("db")
public class PersonDataAccessService implements PersonDao {
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPeopleById(UUID id) {
        // return Optional.empty();
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPeopleById(id);
        if(personMaybe.isEmpty())
            return 0;
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person newPerson) {
        return selectPeopleById(id).map(person -> {
            int indexOfPerson = DB.indexOf(person);
            if(indexOfPerson >= 0) {
                DB.set(indexOfPerson, new Person(id, newPerson.getName()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
