package com.vodafone.application.assignment.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.vodafone.application.assignment.model.Car;
import com.vodafone.application.assignment.model.Sedan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
public class CarServiceTests {
    
    @Mock
    private CarService carService;

    @MockBean
    private CarFactory carFactory;

    @Test
    public void createTest_WhenNull_ShouldBeNull(){
        String result = carService.createCar(null);
        Assertions.assertNull(result);
    }

    @Test
    public void createTest_WhenUnknownInput_ShouldBeNull(){
        String result = carService.createCar("unknown");
        Assertions.assertNull(result);
    }

    @Test
    public void createTest_WhenCorrectInput_ShouldBeString(){
        Car mockedCar = mock(Sedan.class);
        when(carFactory.getCarByType("sedan")).thenReturn(mockedCar);
        String result = carService.createCar("sedan");
        Assertions.assertEquals("Sedan Car", result);
    }
    
}