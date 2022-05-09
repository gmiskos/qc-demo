package com.example.qcdemo.service;

import com.example.qcdemo.entities.CountryLanguage;

import java.util.List;

public interface CountryLanguageService {

    List<CountryLanguage> findCountryLanguages(Long countryId);
}
