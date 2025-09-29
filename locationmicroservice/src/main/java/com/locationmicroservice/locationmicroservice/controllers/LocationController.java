/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.locationmicroservice.locationmicroservice.controllers;

import com.locationmicroservice.locationmicroservice.models.Location;
import com.locationmicroservice.locationmicroservice.services.LocationService;
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

/**
 *
 * @author Rania
 */
@RestController
@RequestMapping("/locations")

public class LocationController {
    @Autowired
    private LocationService locationService;
    
    @GetMapping("/")
    public ResponseEntity<List<Location>> showAlllocations(){
    List <Location> locations=this.locationService.getAllLocations();
    return new ResponseEntity(locations,HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Location> getRLocationById(@PathVariable Long id){
        Location retreivedLocation=this.locationService.getLocationById(id);
        return new ResponseEntity<>(retreivedLocation,HttpStatus.OK);         
    }
    
    @PostMapping("/add")
    public ResponseEntity<Location> addLocation(@RequestBody Location location){
        Location newLocation=this.locationService.addLocation(location);
        return new ResponseEntity<>(newLocation,HttpStatus.CREATED);
    }
}
