/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maintenance_microservice.maintenance_microservice.controllers;

import com.maintenance_microservice.maintenance_microservice.VO.ResponseTemplateVO;
import com.maintenance_microservice.maintenance_microservice.models.Maintenance;
import com.maintenance_microservice.maintenance_microservice.services.MaintenanceService;
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
@RequestMapping("/maintenances")
public class MaintenanceController {
    @Autowired
    private MaintenanceService maintenanceService;
    
    @GetMapping("/")
    public ResponseEntity<List<Maintenance>> showAllMaintenances(){
    List <Maintenance> maintenances=this.maintenanceService.getAllMaintenances();
    return new ResponseEntity(maintenances,HttpStatus.OK);
    }
    
    
    @PostMapping("/add")
    public ResponseEntity<Maintenance> addMaintenance(@RequestBody Maintenance maintenance){
        Maintenance newMaintenance=this.maintenanceService.addMaintenance(maintenance);
        return new ResponseEntity<>(newMaintenance,HttpStatus.CREATED);
    } 
    
    @GetMapping("/{id}")
    public ResponseEntity<ResponseTemplateVO> getMaintenanceWithFullDetails(@PathVariable("id") Long carId){
       ResponseTemplateVO vo=this.maintenanceService.getMaintenanceWithDetails(carId);
       return new ResponseEntity<>(vo,HttpStatus.OK);
    }
}
