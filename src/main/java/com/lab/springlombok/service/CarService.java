package com.lab.springlombok.service;

import com.lab.springlombok.domain.Car;
import com.lab.springlombok.exceptions.EntityNotFoundException;

public interface CarService {
    Car save(String brand);

    Car findById(Long id) throws EntityNotFoundException;
}
