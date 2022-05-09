package com.example.qcdemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CountryStatsDTO {
    private Long countryId;
    private Integer year;
    private Long population;
    private Long gdp;
    private String countryName;
    private String regionName;
    private String continentName;
}
