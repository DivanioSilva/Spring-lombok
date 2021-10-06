package com.lab.springlombok.service;

import com.lab.springlombok.domain.Car;
import com.lab.springlombok.exceptions.EntityNotFoundException;
import com.lab.springlombok.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car save(final String brand){
        Car car = Car.builder().brand(brand).build();
        return carRepository.save(car);
    }

    @Override
    public Car findById(final Long id) throws EntityNotFoundException {
        return this.carRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("I cannot find this car"));
    }
}
