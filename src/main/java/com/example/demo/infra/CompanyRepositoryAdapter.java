package com.example.demo.infra;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.CompanyEntity;
import com.example.domain.model.Company;
import com.example.domain.port.CompanyRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class CompanyRepositoryAdapter implements CompanyRepository {

    private CompanyJpaRepository companyJpaRepository;

    public CompanyRepositoryAdapter(CompanyJpaRepository companyJpaRepository) {
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
    public Optional<Company> findById(UUID id) {
        return null;
        // return companyJpaRepository.findById(id).map(CompanyEntity::toDomain);
    }

    @Override
    public void save(Company company) {
        //return null;
        //companyJpaRepository.save(CompanyEntity.fromDomain(company));
    }

}

