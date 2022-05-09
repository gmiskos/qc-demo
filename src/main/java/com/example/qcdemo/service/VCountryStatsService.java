package com.example.qcdemo.service;

import com.example.qcdemo.wrapper.CountryStatsWrapper;
import org.springframework.data.domain.Pageable;

public interface VCountryStatsService {
    CountryStatsWrapper searchCountryStats(String regionName, Integer yearFrom, Integer yearTo, Pageable paging);
}
