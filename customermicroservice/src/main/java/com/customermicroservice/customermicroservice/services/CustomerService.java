/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.customermicroservice.customermicroservice.services;

import com.customermicroservice.customermicroservice.VO.ResponseTemplateVO;
import com.customermicroservice.customermicroservice.models.Customer;
import com.customermicroservice.customermicroservice.repositories.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    
    public List<Customer> getAllCustomers(){
    return this.customerRepository.findAll();
    }
    
    public Customer getCustomerById(Long id){
    return this.customerRepository.findById(id).get();
    }
    
    public Customer addCustomer(Customer customer){
    return  this.customerRepository.save(customer);
    }
    
} 

