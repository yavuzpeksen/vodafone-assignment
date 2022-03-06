package com.vodafone.application.assignment.controller;

import static org.mockito.Mockito.when;

import com.vodafone.application.assignment.service.CarService;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    public void whenCorrectInput() throws Exception{
        when(carService.createCar("cabrio")).thenReturn("Cabrio Car");
        mockMvc.perform(MockMvcRequestBuilders.post("/cars")
        .content("cabrio")
        .contentType(MediaType.TEXT_PLAIN))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Cabrio Car has produced.")));
    }

    @Test
    public void whenWrongInput() throws Exception{
        when(carService.createCar("unknown")).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.post("/cars")
        .content("unknown")
        .contentType(MediaType.TEXT_PLAIN))
        .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());
    }

    @Test
    public void whenContentTypeDifferent() throws Exception{
        when(carService.createCar("sedan")).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.post("/cars")
        .content("sedan")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isUnsupportedMediaType());
    }


}
