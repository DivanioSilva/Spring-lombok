package com.lab.springlombok.controller;

import com.lab.springlombok.domain.Person;
import com.lab.springlombok.service.PersonService;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person save(@RequestParam String name){
        log.error("----> {} ", name);
        return personService.save(name);
    }

    @PostMapping(value = "/full", consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person saveFullPerson(@RequestBody Person person){
        return this.personService.save(person);
    }

    @SneakyThrows
    @PutMapping(value = "/{personId}/car/{carId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person addCar(@PathVariable("personId") Long personId, @PathVariable("carId") Long carId) {
        return this.personService.addCar(personId, carId);
    }

    @SneakyThrows
    @GetMapping(value = "/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable Long personId) {
        return this.personService.findById(personId);
    }

    @SneakyThrows
    @GetMapping(value = "/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return this.personService.findAll();
    }
}
