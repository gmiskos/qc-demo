package com.example.qcdemo.boundary;

import com.example.qcdemo.dto.*;
import com.example.qcdemo.entities.Country;
import com.example.qcdemo.entities.CountryLanguage;
import com.example.qcdemo.entities.Stats;
import com.example.qcdemo.service.CountryLanguageService;
import com.example.qcdemo.service.CountryService;
import com.example.qcdemo.service.VCountryStatsService;
import com.example.qcdemo.wrapper.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryBoundary {

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    CountryService countryService;
    @Autowired
    CountryLanguageService countryLanguageService;
    @Autowired
    VCountryStatsService vCountryStatsService;

    public CountryWrapper findAllCountry(int page, int size, boolean sorted){
        CountryWrapper wrapper = new CountryWrapper();

        List<CountryDTO> countries;

        Pageable paging = PageRequest.of(page, size, (sorted)?Sort.by("name").ascending():Sort.by("name").descending());

        Page<Country> pageCtr;

        pageCtr = countryService.findAllCountry(paging);

        countries = pageCtr.getContent().stream().map(this::convertToCountryDto)
                .collect(Collectors.toList());
        wrapper.setCountries(countries);
        wrapper.setCurrentPage(pageCtr.getNumber());
        wrapper.setTotalItems(pageCtr.getTotalElements());
        wrapper.setTotalPages(pageCtr.getTotalPages());
        return wrapper;
    }

    private CountryDTO convertToCountryDto(Country country) {
        CountryDTO countryDTO = modelMapper.map(country, CountryDTO.class);
        countryDTO.setArea(country.getRegion().getName());
        return countryDTO;
    }

    public LanguageWrapper findCountryLanguages(Long countryId) {
        LanguageWrapper wrapper = new LanguageWrapper();
        List<LanguageDTO> languageDTOS;
        List<CountryLanguage> countryLanguages = countryLanguageService.findCountryLanguages(countryId);

        languageDTOS = countryLanguages.stream().map(this::convertToLanguageDto)
                .collect(Collectors.toList());

        wrapper.setLanguages(languageDTOS);
        return wrapper;
    }

    private LanguageDTO convertToLanguageDto(CountryLanguage countryLanguage) {
        return modelMapper.map(countryLanguage, LanguageDTO.class);
    }

    public CountryStatsWrapper searchCountryStats(StatsRequestWrapper requestWrapper) {
        CountryStatsWrapper wrapper = new CountryStatsWrapper();

        Pageable paging = PageRequest.of(requestWrapper.getPage(), requestWrapper.getSize(), Sort.by("countryName").ascending().and(Sort.by("year").descending()));

        wrapper = vCountryStatsService.searchCountryStats(requestWrapper.getRegionName(), requestWrapper.getYearFrom(), requestWrapper.getYearTo(),paging);

        return wrapper;
    }

    public CountryGdpWrapper getCountryStats(int page, int size) {
        CountryGdpWrapper wrapper = new CountryGdpWrapper();

        List<GdpDTO> gdpDTOS;

        Pageable paging = PageRequest.of(page, size);

        Page<CountryGdpDTO> pageCtr;

        pageCtr = countryService.findAllCountryGdp(paging);

        gdpDTOS = new ArrayList<>();
        gdpDTOS = pageCtr.getContent().stream().map(this::convertToGDPDto)
                .collect(Collectors.toList());
        wrapper.setData(gdpDTOS);
        wrapper.setCurrentPage(pageCtr.getNumber());
        wrapper.setTotalItems(pageCtr.getTotalElements());
        wrapper.setTotalPages(pageCtr.getTotalPages());
        return wrapper;
    }

    private GdpDTO convertToGDPDto(CountryGdpDTO gdp) {
        GdpDTO gdpDTO = modelMapper.map(gdp, GdpDTO.class);
        gdpDTO.setCountryId(gdp.getCountryId());
        gdpDTO.setName(gdp.getName());
        gdpDTO.setCountryCode3(gdp.getCountryCode3());
        gdpDTO.setYear(gdp.getYear());
        gdpDTO.setPopulation(gdp.getPopulation());
        gdpDTO.setGdpPerPopulation(gdp.getGdpPerPopulation());
        return gdpDTO;
    }

}
