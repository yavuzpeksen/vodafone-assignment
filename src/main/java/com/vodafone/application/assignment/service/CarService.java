package com.vodafone.application.assignment.service;

import java.util.Optional;

import com.vodafone.application.assignment.model.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    
    @Autowired
    private CarFactory carFactory;

    public CarService(CarFactory carFactory) {
        this.carFactory = carFactory;
    }

    public String createCar(String type){
        Car car = carFactory.getCarByType(type);
        return Optional.ofNullable(car).map(Car::getType).orElse(null);
    }
}
