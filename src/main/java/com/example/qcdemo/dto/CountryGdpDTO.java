package com.example.qcdemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public interface CountryGdpDTO {
    Long getCountryId();
    String getName();
    String getCountryCode3();
    Integer getYear();
    Long getPopulation();
    Double getGdpPerPopulation();
}
