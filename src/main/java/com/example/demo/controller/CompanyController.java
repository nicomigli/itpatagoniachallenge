package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.model.Company;
import com.example.demo.usecases.GetCompaniesAdheredLastMonthUseCase;
import com.example.demo.usecases.GetCompaniesWithTransfersUseCase;
import com.example.demo.usecases.RegisterCompanyUseCase;
import com.example.demo.webmodel.CompanyWebModel;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private GetCompaniesWithTransfersUseCase getCompaniesWithTransfersUseCase;

    @Autowired
    private GetCompaniesAdheredLastMonthUseCase getCompaniesAdheredLastMonthUseCase;

    @Autowired
    private RegisterCompanyUseCase registerCompanyUseCase;
    
    @GetMapping("/transfers-last-month")
    public ResponseEntity<List<CompanyWebModel>> getCompaniesWithTransfers() {
        List<Company> companies = getCompaniesWithTransfersUseCase.execute();
        List<CompanyWebModel> companyWebModels = companies.stream()
                                                           .map(CompanyWebModel::fromDomainModel)
                                                           .collect(Collectors.toList());
        return ResponseEntity.ok(companyWebModels);

    }

    @GetMapping("/adhered-last-month")
    public ResponseEntity<List<CompanyWebModel>> getCompaniesAdheredLastMonth() {
        List<Company> companies = getCompaniesAdheredLastMonthUseCase.execute();
        List<CompanyWebModel> companyWebModels = companies.stream()
                                                           .map(CompanyWebModel::fromDomainModel)
                                                           .collect(Collectors.toList());
        return ResponseEntity.ok(companyWebModels);
    }

    @PostMapping("/adhere")
    public void adhereCompany(@RequestBody CompanyWebModel company) {
        registerCompanyUseCase.execute(company.getCuit(),company.getBusinessName());
    }

}
