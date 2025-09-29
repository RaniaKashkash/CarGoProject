/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reporting_microservice.reporting_microservice.controllers;

import com.reporting_microservice.reporting_microservice.models.Report;
import com.reporting_microservice.reporting_microservice.repositories.ReportRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportRepository reportRepository;

    public ReportController(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @PostMapping
    public String receiveReport(@RequestBody Report report) {
        reportRepository.save(report);
        return "Report saved for reservation " + report.getReservationId();
    }

    @GetMapping
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }
}

