package com.example.qcdemo.boundary;

import com.example.qcdemo.dto.RegionDTO;
import com.example.qcdemo.entities.Region;
import com.example.qcdemo.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegionBoundary {

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    RegionService regionService;

    public List<RegionDTO> findAllRegions(){
        List<RegionDTO> regions;

        regions = regionService.findAllRegions().stream().map(this::convertToRegionDto)
                .collect(Collectors.toList());;


        return regions;
    }

    private RegionDTO convertToRegionDto(Region region) {
        return modelMapper.map(region, RegionDTO.class);
    }

}
