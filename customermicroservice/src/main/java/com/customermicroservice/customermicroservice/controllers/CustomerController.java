/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.customermicroservice.customermicroservice.controllers;

import com.customermicroservice.customermicroservice.models.Customer;
import com.customermicroservice.customermicroservice.services.CustomerService;
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
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/")
    public ResponseEntity<List<Customer>> showAllCustomers(){
    List <Customer> customers=this.customerService.getAllCustomers();
    return new ResponseEntity(customers,HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        Customer retreivedCustomer=this.customerService.getCustomerById(id);
        return new ResponseEntity<>(retreivedCustomer,HttpStatus.OK);         
    }
    
    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer newCustomer=this.customerService.addCustomer(customer);
        return new ResponseEntity<>(newCustomer,HttpStatus.CREATED);
    }
}
    
