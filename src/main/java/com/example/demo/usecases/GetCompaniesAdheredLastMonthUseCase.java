package com.example.demo.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.Company;
import com.example.demo.domain.port.CompanyRepository;

@Service
public class GetCompaniesAdheredLastMonthUseCase  {

    @Autowired
    private CompanyRepository companyRepository;

    public GetCompaniesAdheredLastMonthUseCase(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> execute() {
        return companyRepository.getCompaniesAdheredLastMonth();
    }
    
}
