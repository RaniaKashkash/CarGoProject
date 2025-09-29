/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marketing_microservice.marketing_microservice.controllers;

import com.marketing_microservice.marketing_microservice.models.Marketing;
import com.marketing_microservice.marketing_microservice.repositories.MarketingRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rania
 */
@RestController
@RequestMapping("/marketings")
public class MarketingController {

    private final MarketingRepository marketingRepository;

    public MarketingController(MarketingRepository marketingRepository) {
        this.marketingRepository = marketingRepository;
    }

    @PostMapping
    public String receiveMarketingcampaign(@RequestBody Marketing marketing) {
        marketingRepository.save(marketing);
        return "Promotion saved: " + marketing.getTitle();
    }

    @GetMapping
    public List<Marketing> getAllMarketingcampaigns() {
        return marketingRepository.findAll();
    }
}



