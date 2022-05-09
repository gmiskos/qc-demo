package com.example.qcdemo.dto;

import com.example.qcdemo.entities.Region;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegionDTO {
    private Long regionId;
    private String name;
    private String continentId;
}
