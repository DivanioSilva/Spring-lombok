package com.lab.springlombok.service;

import com.lab.springlombok.domain.Car;
import com.lab.springlombok.domain.Person;
import com.lab.springlombok.dto.PersonDto;
import com.lab.springlombok.exceptions.EntityNotFoundException;
import com.lab.springlombok.exceptions.ExceptionsBag;
import com.lab.springlombok.mapper.PersonMapper;
import com.lab.springlombok.repository.CarRepository;
import com.lab.springlombok.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final CarRepository carRepository;
    private final PersonMapper personMapper;
    private final ExceptionsBag exceptionsBag;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository,
                             CarRepository carRepository,
                             PersonMapper personMapper,
                             ExceptionsBag exceptionsBag) {
        this.personRepository = personRepository;
        this.carRepository = carRepository;
        this.personMapper = personMapper;
        this.exceptionsBag = exceptionsBag;
    }

    @Override
    public PersonDto save(final String name){
        Person person = Person.builder().name(name).build();
        return this.personMapper.personToPersonDTO(this.personRepository.save(person));
    }

    @Override
    public PersonDto save(PersonDto personDto) {
        Person person = this.personMapper.personDtoToPerson(personDto);
        Person savedPerson = this.personRepository.save(person);
        return this.personMapper.personToPersonDTO(savedPerson);
    }

    @Override
    public PersonDto findById(final Long id) throws ExceptionsBag {
        Optional<Person> optionalPerson = this.personRepository.findById(id);

        if(optionalPerson.isPresent()){
            return this.personMapper.personToPersonDTO(optionalPerson.get());
        }
        exceptionsBag.addExceptions(new EntityNotFoundException("I cannot find this person using "+id+" id"));
        throw exceptionsBag;
    }

    @Override
    public PersonDto addCar(final Long personId, final Long carId) throws ExceptionsBag {
        Optional<Person> optionalPerson = this.personRepository.findById(personId);
        if(!optionalPerson.isPresent()){
            exceptionsBag.addExceptions(new EntityNotFoundException("I cannot find any person using "+personId+" id"));
        }

        Optional<Car> optionalCar = this.carRepository.findById(carId);
        if(!optionalCar.isPresent()){
            exceptionsBag.addExceptions(new EntityNotFoundException("I cannot find any car using "+carId+" id"));
        }

        if(exceptionsBag.isNotEmpty()){
            throw exceptionsBag;
        }

        Person person = optionalPerson.get();
        Car car = optionalCar.get();

        person.addCar(car);

        return this.personMapper.personToPersonDTO(personRepository.save(person));
    }

    @Override
    public List<PersonDto> findAll() {
        return this.personMapper.personToPersonDTOList(this.personRepository.findAll());
    }
}
