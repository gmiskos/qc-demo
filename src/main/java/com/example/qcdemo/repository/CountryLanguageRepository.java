package com.example.qcdemo.repository;

import com.example.qcdemo.entities.CountryLanguage;
import com.example.qcdemo.entities.CountryLanguageId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageId> {
    List<CountryLanguage> findByCountryId(Long countryId);
}
