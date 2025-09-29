/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maintenance_microservice.maintenance_microservice.services;

import com.maintenance_microservice.maintenance_microservice.VO.Car;
import com.maintenance_microservice.maintenance_microservice.VO.ResponseTemplateVO;
import com.maintenance_microservice.maintenance_microservice.models.Maintenance;
import com.maintenance_microservice.maintenance_microservice.repositories.MaintenanceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Rania
 */
@Service
public class MaintenanceService {
    @Autowired
    private MaintenanceRepository maintenanceRepository;
    
     @Autowired
    private RestTemplate restTemplate;
    
    public List<Maintenance> getAllMaintenances(){
    return this.maintenanceRepository.findAll();
    }
    
    public Maintenance getMaintenanceById(Long id){
    return this.maintenanceRepository.findById(id).get();
    }
    
    public Maintenance addMaintenance(Maintenance maintenance){
    return  this.maintenanceRepository.save(maintenance);
    }
    
    public ResponseTemplateVO getMaintenanceWithDetails(Long carId) {
        Maintenance maintenance=this.getMaintenanceById(carId);
        Car car=this.restTemplate.getForObject("http://carmicroservice/cars/"+maintenance.getCarId(), Car.class);

        ResponseTemplateVO vo= new ResponseTemplateVO();
        vo.setMaintenance(maintenance);
        vo.setCar(car);
        return vo;
    }  
    }  

