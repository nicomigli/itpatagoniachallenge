package com.example.demo.webmodel;

import com.example.demo.domain.model.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyWebModel {
    private String cuit;
    private String businessName;
    private String adhesionDate;

    public static CompanyWebModel fromDomainModel(Company company) {
        CompanyWebModel model = new CompanyWebModel();
        model.cuit = company.getCuit();
        model.businessName = company.getBusinessName();
        model.adhesionDate = company.getAdhesionDate().toString();
        return model;
    }
}

