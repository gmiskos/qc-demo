package com.example.qcdemo.service.impl;

import com.example.qcdemo.entities.CountryLanguage;
import com.example.qcdemo.repository.CountryLanguageRepository;
import com.example.qcdemo.service.CountryLanguageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
@Primary
public class CountryLanguageServiceImpl implements CountryLanguageService {

    @Autowired
    CountryLanguageRepository countryLanguageRepository;


    @Override
    public List<CountryLanguage> findCountryLanguages(Long countryId) {
        return countryLanguageRepository.findByCountryId(countryId);
    }
}
