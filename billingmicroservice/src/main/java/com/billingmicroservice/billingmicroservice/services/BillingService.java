/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billingmicroservice.billingmicroservice.services;

import com.billingmicroservice.billingmicroservice.VO.Reservation;
import com.billingmicroservice.billingmicroservice.VO.ResponseTemplateVO;
import com.billingmicroservice.billingmicroservice.models.Billing;
import com.billingmicroservice.billingmicroservice.repositories.BillingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Rania
 */
@Service
public class BillingService {
    @Autowired
    private BillingRepository billingRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public List<Billing> getAllBilling(){
    return this.billingRepository.findAll();
    }
    
    public Billing getBillingById(Long id){
    return this.billingRepository.findById(id).get();
    }
    
    public Billing addBilling(Billing billing){
    return  this.billingRepository.save(billing);
    }
    
        public ResponseTemplateVO getBillingWithDetailsByBillingId(Long billingId) {
        Billing billing=this.getBillingById(billingId);
        ResponseTemplateVO resVo = this.restTemplate.getForObject(
        "http://reservationmicroservice/reservations/" + billing.getReservationId(),
        ResponseTemplateVO.class);

        Reservation reservation = resVo.getReservation();
        ResponseTemplateVO vo= new ResponseTemplateVO();
        vo.setBilling(billing);
        vo.setReservation(reservation);
        return vo;
    } 
}
   

