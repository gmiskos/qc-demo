package com.example.qcdemo.dto;

import com.example.qcdemo.entities.Region;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CountryDTO {
    private Long countryId;
    private String name;
    private String area;
    private String countryCode2;

    public String getArea(Region region)  {
        return region.getName();
    }
}
