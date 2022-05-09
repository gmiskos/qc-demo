package com.example.qcdemo.service;

import com.example.qcdemo.dto.CountryGdpDTO;
import com.example.qcdemo.entities.Country;
import com.example.qcdemo.entities.Stats;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CountryService {
    Page<Country> findAllCountry(Pageable paging);

    Page<CountryGdpDTO> findAllCountryGdp(Pageable paging);
}
