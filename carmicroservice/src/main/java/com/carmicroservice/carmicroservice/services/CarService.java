/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmicroservice.carmicroservice.services;

import com.carmicroservice.carmicroservice.models.Car;
import com.carmicroservice.carmicroservice.repositories.CarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    @Autowired
    private CarRepository CarRepository;
    
    public List<Car> getAllCars(){
    return this.CarRepository.findAll();
    }
    
    public Car getCarById(Long id){
    return this.CarRepository.findById(id).get();
    }
    
    public Car addCar(Car car){
    return  this.CarRepository.save(car);
    }
    
}
