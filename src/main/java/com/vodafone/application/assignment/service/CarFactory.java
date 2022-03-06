package com.vodafone.application.assignment.service;

import com.vodafone.application.assignment.model.Cabrio;
import com.vodafone.application.assignment.model.Car;
import com.vodafone.application.assignment.model.Hatchback;
import com.vodafone.application.assignment.model.Sedan;

import org.springframework.stereotype.Service;

@Service
public class CarFactory {
    
    public Car getCarByType(String typeName){
        if(typeName == null){
           return null;
        }		
        if(typeName.equalsIgnoreCase("CABRIO")){
           return new Cabrio();
           
        } else if(typeName.equalsIgnoreCase("SEDAN")){
           return new Sedan();
           
        } else if(typeName.equalsIgnoreCase("HATCHBACK")){
           return new Hatchback();
        }
        
        return null;
     }
}
