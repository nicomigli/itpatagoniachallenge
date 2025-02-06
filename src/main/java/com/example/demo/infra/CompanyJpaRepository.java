package com.example.demo.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.CompanyEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface CompanyJpaRepository extends JpaRepository<CompanyEntity, UUID> {

    @Query("SELECT DISTINCT c FROM CompanyEntity c JOIN c.transfers t WHERE t.createdAt > :lastMonth")
    List<CompanyEntity> findCompaniesWithTransfersLastMonth(LocalDateTime  lastMonth);

    List<CompanyEntity> findByAdhesionDateAfter(LocalDateTime  lastMonth);
}
