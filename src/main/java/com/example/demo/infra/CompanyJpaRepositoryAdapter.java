package com.example.demo.infra;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.model.Company;
import com.example.demo.domain.port.CompanyRepository;
import com.example.demo.entities.CompanyEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CompanyJpaRepositoryAdapter implements CompanyRepository {

    private CompanyJpaRepository companyJpaRepository;

    public CompanyJpaRepositoryAdapter(CompanyJpaRepository companyJpaRepository) {
        this.companyJpaRepository = companyJpaRepository;
    }

    @Override
    public List<Company> getCompaniesWithTransfersLastMonth() {
        LocalDate lastMonthDate = LocalDate.now().minusMonths(1);
        LocalDateTime lastMonthStart = lastMonthDate.atStartOfDay();
        return companyJpaRepository.findCompaniesWithTransfersLastMonth(lastMonthStart)
                .stream().map(CompanyEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Company> getCompaniesAdheredLastMonth() {
        LocalDate lastMonthDate = LocalDate.now().minusMonths(1);
        LocalDateTime lastMonthStart = lastMonthDate.atStartOfDay();
        return companyJpaRepository.findByAdhesionDateAfter(lastMonthStart)
                .stream().map(CompanyEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void save(Company company) {
        companyJpaRepository.save(CompanyEntity.fromDomain(company));
    }

}

