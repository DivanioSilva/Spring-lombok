package com.lab.springlombok.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lab.springlombok.domain.Person;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public @Data class CarDto {
    private Long id;
    private String brand;
    @JsonIgnore
    private Person person;
}
