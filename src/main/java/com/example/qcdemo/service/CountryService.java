package com.example.qcdemo.service;

import com.example.qcdemo.entities.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CountryService {
    Page<Country> findAllCountry(Pageable paging);
}
