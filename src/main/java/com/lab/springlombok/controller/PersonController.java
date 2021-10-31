package com.lab.springlombok.controller;

import com.lab.springlombok.domain.Person;
import com.lab.springlombok.dto.PersonDto;
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
    public PersonDto save(@RequestParam String name){
        log.error("----> {} ", name);
        return personService.save(name);
    }

    @PostMapping(value = "/full", consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto saveFullPerson(@RequestBody PersonDto personDto){
        return this.personService.save(personDto);
    }

    @SneakyThrows
    @PutMapping(value = "/{personId}/car/{carId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto addCar(@PathVariable("personId") Long personId, @PathVariable("carId") Long carId) {
        return this.personService.addCar(personId, carId);
    }

    @SneakyThrows
    @GetMapping(value = "/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto findById(@PathVariable Long personId) {
        return this.personService.findById(personId);
    }

    @SneakyThrows
    @GetMapping(value = "/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDto> findAll() {
        return this.personService.findAll();
    }
}
