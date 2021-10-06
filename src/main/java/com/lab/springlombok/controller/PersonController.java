package com.lab.springlombok.controller;

import com.lab.springlombok.domain.Person;
import com.lab.springlombok.exceptions.EntityNotFoundException;
import com.lab.springlombok.exceptions.ExceptionsBag;
import com.lab.springlombok.service.PersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping(value = "/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person save(@RequestParam String name){
        log.error("----> {} ", name);
        return personService.save(name);
    }

    @RequestMapping(value = "/full", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person saveFullPerson(@RequestBody Person person){
        return this.personService.save(person);
    }

    @RequestMapping(value = "/{personId}/car/{carId}", method = RequestMethod.PUT)
    public Person addCar(@RequestParam("personId") Long personId, @RequestParam("carId") Long carId) throws ExceptionsBag, EntityNotFoundException {
        return this.personService.addCar(personId, carId);
    }
}
