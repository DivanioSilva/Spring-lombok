package com.lab.springlombok.controller;

import com.lab.springlombok.domain.Person;
import com.lab.springlombok.service.PersonService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person save(@RequestParam String name){
        return personService.save(name);
    }
}
