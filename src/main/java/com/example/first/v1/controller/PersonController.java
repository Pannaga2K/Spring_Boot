package com.example.first.v1.controller;

import java.util.List;
import java.util.UUID;
import javax.validation.Valid;

import com.example.first.v1.model.Person;
import com.example.first.v1.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // INSERT
    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person person) {
        personService.addPerson(person);
    }

    // FETCH
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    // FETCH BY ID
    @GetMapping(path = "{id}")
    public Person getPeopleById(@PathVariable("id") UUID id) {
        return personService.getPeopleById(id).orElse(null);
    }

    // DELETE
    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePeopleById(id);
    }

    // UPDATE
    @PutMapping(path = "{id}")
    public void updatePersonById(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person person) {
        personService.updatePeopleById(id, person);
    }

}
