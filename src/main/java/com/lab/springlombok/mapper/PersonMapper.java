package com.lab.springlombok.mapper;

import com.lab.springlombok.domain.Person;
import com.lab.springlombok.dto.PersonDto;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDto personToPersonDTO(Person person);

    Person personDtoToPerson(PersonDto personDto);

    List<PersonDto> personToPersonDTOList(List<Person> personList);
}
