package com.lab.springlombok.controller;

import com.lab.springlombok.domain.Person;
import com.lab.springlombok.service.PersonService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
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
        log.info("----> {} ", name);
        return personService.save(name);
    }
}
