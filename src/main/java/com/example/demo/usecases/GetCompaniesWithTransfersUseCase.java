package com.example.demo.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.Company;
import com.example.demo.domain.port.CompanyRepository;

@Service
public class GetCompaniesWithTransfersUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    public GetCompaniesWithTransfersUseCase(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> execute() {
        return companyRepository.getCompaniesWithTransfersLastMonth();
    }
    
}
