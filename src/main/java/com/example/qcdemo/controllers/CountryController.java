package com.example.qcdemo.controllers;

import com.example.qcdemo.boundary.CountryBoundary;
import com.example.qcdemo.wrapper.CountryStatsWrapper;
import com.example.qcdemo.wrapper.CountryWrapper;
import com.example.qcdemo.wrapper.LanguageWrapper;
import com.example.qcdemo.wrapper.StatsRequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CountryController {

    @Autowired
    CountryBoundary countryBoundary;

    @GetMapping(path = "/countries", produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    CountryWrapper getAllCountries(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam boolean sorted
    ) {
        return countryBoundary.findAllCountry(page, size, sorted);
    }

    @GetMapping(path = "/languages/{countryId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    LanguageWrapper getCountryLanguages(@PathVariable Long countryId) {
        return countryBoundary.findCountryLanguages(countryId);
    }

    @PostMapping(
            path = "/countries/stats",
            produces= MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody
    CountryStatsWrapper searchCountryStats(@RequestBody StatsRequestWrapper requestWrapper) {
        return countryBoundary.searchCountryStats(requestWrapper);
    }
}
