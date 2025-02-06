package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.example.demo.domain.model.Company;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyEntity {

    public CompanyEntity(UUID id, String cuit, String businessName, LocalDateTime adhesionDate) {
        this.id = id;
        this.cuit = cuit;
        this.businessName = businessName;
        this.adhesionDate = adhesionDate;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String cuit;

    @Column(nullable = false)
    private String businessName;

    @Column(nullable = false)
    private LocalDateTime adhesionDate;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TransferEntity> transfers;

    // Conversión entre entidad y dominio
    public Company toDomain() {
        return new Company(id, cuit, businessName, adhesionDate);
    }

    public static CompanyEntity fromDomain(Company company) {
        return new CompanyEntity(company.getId(), company.getCuit(), company.getBusinessName(), company.getAdhesionDate());
    }
}

