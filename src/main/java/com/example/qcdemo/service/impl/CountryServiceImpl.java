package com.example.qcdemo.service.impl;

import com.example.qcdemo.entities.Country;
import com.example.qcdemo.repository.CountryRepository;
import com.example.qcdemo.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
@Primary
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    private final EntityManager entityManager;

    @Override
    public Page<Country> findAllCountry(Pageable paging) {
        return countryRepository.findAll(paging);
    }


}
