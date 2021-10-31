package com.lab.springlombok.service;

import com.lab.springlombok.domain.Person;
import com.lab.springlombok.dto.PersonDto;
import com.lab.springlombok.exceptions.EntityNotFoundException;
import com.lab.springlombok.exceptions.ExceptionsBag;

import java.util.List;

public interface PersonService {
    PersonDto save(String name);

    PersonDto save(PersonDto personDto);

    PersonDto findById(Long id) throws EntityNotFoundException, ExceptionsBag;

    PersonDto addCar(Long personId, Long carId) throws EntityNotFoundException, ExceptionsBag;

    List<PersonDto> findAll();
}
