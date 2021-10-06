package com.lab.springlombok.service;

import com.lab.springlombok.domain.Person;
import com.lab.springlombok.exceptions.EntityNotFoundException;

public interface PersonService {
    Person save(String name);

    Person save(Person person);

    Person findById(Long id) throws EntityNotFoundException;

    Person addCar(Long personId, Long carId) throws EntityNotFoundException;
}
