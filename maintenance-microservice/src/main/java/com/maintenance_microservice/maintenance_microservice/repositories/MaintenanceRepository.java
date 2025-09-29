/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.maintenance_microservice.maintenance_microservice.repositories;

import com.maintenance_microservice.maintenance_microservice.models.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rania
 */
@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance , Long>{
    
}
