package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.usecases.GetCompaniesAdheredLastMonthUseCase;
import com.example.demo.usecases.GetCompaniesWithTransfersUseCase;
import com.example.domain.model.Company;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private GetCompaniesWithTransfersUseCase getCompaniesWithTransfersUseCase;

    @Autowired
    private GetCompaniesAdheredLastMonthUseCase getCompaniesAdheredLastMonthUseCase;
    
    @GetMapping("/transfers-last-month")
    public List<Company> getCompaniesWithTransfers() {
        return getCompaniesWithTransfersUseCase.execute();
    }

    @GetMapping("/adhered-last-month")
    public List<Company> getCompaniesAdheredLastMonth() {
        return getCompaniesAdheredLastMonthUseCase.execute();
    }

    // @PostMapping("/adhere")
    // public void adhereCompany(@RequestBody Company company) {
    //     companyService.registerCompany(company);
    // }

}
