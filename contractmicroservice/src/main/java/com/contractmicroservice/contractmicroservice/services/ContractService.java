/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contractmicroservice.contractmicroservice.services;



import com.contractmicroservice.contractmicroservice.VO.Reservation;
import com.contractmicroservice.contractmicroservice.VO.ResponseTemplateVO;
import com.contractmicroservice.contractmicroservice.models.Contract;
import com.contractmicroservice.contractmicroservice.repositories.ContractRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Rania
 */
@Service
public class ContractService {
    @Autowired
    private ContractRepository contractRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public List<Contract> getAllContracts(){
    return this.contractRepository.findAll();
    }
    
    public Contract getContractById(Long id){
    return this.contractRepository.findById(id).get();
    }
    
    public Contract addContract(Contract contract){
    return  this.contractRepository.save(contract);
    }
    
        public ResponseTemplateVO getContractWithDetailsByContractId(Long contractId) {
        Contract contract=this.getContractById(contractId);
        ResponseTemplateVO resVo = this.restTemplate.getForObject(
        "http://reservationmicroservice/reservations/" + contract.getReservationId(),
        ResponseTemplateVO.class);

        Reservation reservation = resVo.getReservation();
        ResponseTemplateVO vo= new ResponseTemplateVO();
        vo.setContract(contract);
        vo.setReservation(reservation);
        return vo;
    }  

}
 

