/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contractmicroservice.contractmicroservice.controllers;

import com.contractmicroservice.contractmicroservice.VO.ResponseTemplateVO;
import com.contractmicroservice.contractmicroservice.models.Contract;
import com.contractmicroservice.contractmicroservice.services.ContractService;
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
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;
    
    @GetMapping("/")
    public ResponseEntity<List<Contract>> showAlllocations(){
    List <Contract> contracts=this.contractService.getAllContracts();
    return new ResponseEntity(contracts,HttpStatus.OK);
    }
    
    
    @PostMapping("/add")
    public ResponseEntity<Contract> addContract(@RequestBody Contract contract){
        Contract newContract=this.contractService.addContract(contract);
        return new ResponseEntity<>(newContract,HttpStatus.CREATED);
    }
    
     @GetMapping("/{id}")
    public ResponseEntity<ResponseTemplateVO> getContractWithFullDetailsByContractId(@PathVariable("id") Long contractId){
       ResponseTemplateVO vo=this.contractService.getContractWithDetailsByContractId(contractId); 
       return new ResponseEntity<>(vo,HttpStatus.OK);
    }
}

