/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.marketing_microservice.marketing_microservice.repositories;

import com.marketing_microservice.marketing_microservice.models.Marketing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rania
 */
@Repository
public interface MarketingRepository extends JpaRepository<Marketing, Long> {}

