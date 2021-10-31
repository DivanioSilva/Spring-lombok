package com.lab.springlombok.dto;

import com.lab.springlombok.domain.Car;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Builder
public @Data class PersonDto {
    private Long id;
    @NotBlank(message = "is mandatory")
    private String name;
    @NotBlank(message = "is mandatory")
    private String lastname;
    @NotBlank(message = "is mandatory")
    @Email(message = "malformed email")
    private String email;

    private List<Car> cars;

    public PersonDto() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }
}
