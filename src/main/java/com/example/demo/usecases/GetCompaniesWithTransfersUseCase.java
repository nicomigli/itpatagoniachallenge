package com.example.demo.usecases;

import java.util.List;

import com.example.demo.domain.model.Company;

public interface GetCompaniesWithTransfersUseCase {
    List<Company> execute();
}

