package com.lab.springlombok.service;

import com.lab.springlombok.domain.Car;
import com.lab.springlombok.domain.Person;
import com.lab.springlombok.exceptions.EntityNotFoundException;
import com.lab.springlombok.repository.CarRepository;
import com.lab.springlombok.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final CarRepository carRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, CarRepository carRepository) {
        this.personRepository = personRepository;
        this.carRepository = carRepository;
    }

    @Override
    public Person save(final String name){
        Person person = Person.builder().name(name).build();
        return this.personRepository.save(person);
    }

    @Override
    public Person save(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public Person findById(final Long id) throws EntityNotFoundException {
        return this.personRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("I cannot find this person"));
    }

    @Override
    public Person addCar(final Long personId, final Long carId) throws EntityNotFoundException {
        Person person = this.personRepository.findById(personId).orElseThrow(() ->
                new EntityNotFoundException("I cannot find this person"));

        Car car = this.carRepository.findById(carId).orElseThrow(() ->
                new EntityNotFoundException("I cannot find this car"));

        person.setCar(car);

        return personRepository.save(person);
    }
}
