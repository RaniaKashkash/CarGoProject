/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.locationmicroservice.locationmicroservice.services;

import com.locationmicroservice.locationmicroservice.models.Location;
import com.locationmicroservice.locationmicroservice.repositories.LocationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rania
 */
@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;
    
     public List<Location> getAllLocations(){
    return this.locationRepository.findAll();
    }
    
    public Location getLocationById(Long id){
    return this.locationRepository.findById(id).get();
    }
    
    public Location addLocation(Location location){
    return  this.locationRepository.save(location);
    }
}
