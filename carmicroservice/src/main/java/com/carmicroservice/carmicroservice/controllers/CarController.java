/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmicroservice.carmicroservice.controllers;
import com.carmicroservice.carmicroservice.models.Car;
import com.carmicroservice.carmicroservice.services.CarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService CarService;
    
    @GetMapping("/")
    public ResponseEntity<List<Car>> showAllCars(){
    List <Car> cars=this.CarService.getAllCars();
    return new ResponseEntity(cars,HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id){
        Car retreivedCar=this.CarService.getCarById(id);
        return new ResponseEntity<>(retreivedCar,HttpStatus.OK);         
    }
    
    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        Car newCar=this.CarService.addCar(car);
        return new ResponseEntity<>(newCar,HttpStatus.CREATED);
    }
    
}
