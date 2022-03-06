package com.vodafone.application.assignment.controller;

import com.vodafone.application.assignment.service.CarService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService){
        this.carService = carService;
    }

    @PostMapping(path = "", produces = "text/plain", consumes = "text/plain")
    public ResponseEntity<String> bcreateCar(@RequestBody String typeName){
        String response = carService.createCar(typeName);
        StringBuilder sbuilder = new StringBuilder();
        if(response == null){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(sbuilder.toString());
        }
        sbuilder.append(response).append(" has produced.");
        return new ResponseEntity<String>(sbuilder.toString(), HttpStatus.OK);
    }

}
