package com.example.first.v1.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.first.v1.dao.PersonDao;
import com.example.first.v1.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("db") PersonDao personDao) {
        this.personDao = personDao;
    }

    // INSERT
    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    // FETCH
    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    // FETCH BY ID
    public Optional<Person> getPeopleById(UUID id) {
        return personDao.selectPeopleById(id);
    }

    // DELETE
    public int deletePeopleById(UUID id) {
        return personDao.deletePersonById(id);
    }

    // UPDATE
    public int updatePeopleById(UUID id, Person person) {
        return personDao.updatePersonById(id, person);
    }
}
