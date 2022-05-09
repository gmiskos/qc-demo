package com.example.qcdemo.dto;

import com.example.qcdemo.entities.Region;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GdpDTO {
    private Long countryId;
    private String name;
    private String countryCode3;
    private Integer year;
    private Long population;
    private Double gdpPerPopulation;
}
