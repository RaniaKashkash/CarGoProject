/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billingmicroservice.billingmicroservice.VO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private Long customerId; 

    private Long carId;
    
    private Long locationId;
    
    private LocalDateTime pickupDateTime;
    
    private LocalDateTime dropoffDateTime;
    
    private String pickupLocation; 

    private String dropoffLocation;
    
    private Double totalPrice;

    private  String status; 

    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
 
}
 


