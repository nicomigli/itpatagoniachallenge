package com.example.demo.usecases;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.Company;
import com.example.demo.domain.port.CompanyRepository;

@Service
public class RegisterCompanyUseCaseImpl implements RegisterCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    public RegisterCompanyUseCaseImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void execute(String cuit, String businessName) {
        Company company = Company.builder()
                .cuit(cuit)
                .businessName(businessName)
                .adhesionDate(LocalDate.now().atStartOfDay())
                .build();
        companyRepository.save(company);
    }
}

