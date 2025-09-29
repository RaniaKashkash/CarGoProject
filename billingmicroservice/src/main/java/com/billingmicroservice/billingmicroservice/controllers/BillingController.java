/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billingmicroservice.billingmicroservice.controllers;

import com.billingmicroservice.billingmicroservice.VO.ResponseTemplateVO;
import com.billingmicroservice.billingmicroservice.models.Billing;
import com.billingmicroservice.billingmicroservice.services.BillingService;
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
@RequestMapping("/billings")
public class BillingController {
   
    @Autowired
    private BillingService billingService;
    
    @GetMapping("/")
    public ResponseEntity<List<Billing>> showAlllocations(){
    List <Billing> billings=this.billingService.getAllBilling();
    return new ResponseEntity(billings,HttpStatus.OK);
    }
    
    
    @PostMapping("/add")
    public ResponseEntity<Billing> addBilling(@RequestBody Billing billing){
        Billing newBilling=this.billingService.addBilling(billing);
        return new ResponseEntity<>(newBilling,HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ResponseTemplateVO> getContractWithFullDetailsByContractId(@PathVariable("id") Long billingId){
       ResponseTemplateVO vo=this.billingService.getBillingWithDetailsByBillingId(billingId); 
       return new ResponseEntity<>(vo,HttpStatus.OK);
    }

}
