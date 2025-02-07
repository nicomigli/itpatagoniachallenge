package com.example.demo.domain.port;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.domain.model.Company;

public interface CompanyRepository {
    List<Company> getCompaniesWithTransfersLastMonth();
    List<Company> getCompaniesAdheredLastMonth();
    void save(Company company);
}

