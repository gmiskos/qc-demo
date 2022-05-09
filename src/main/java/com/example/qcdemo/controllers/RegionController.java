package com.example.qcdemo.controllers;

import com.example.qcdemo.boundary.RegionBoundary;
import com.example.qcdemo.dto.RegionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RegionController {

    @Autowired
    RegionBoundary regionBoundary;

    @GetMapping(path = "/regions", produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<RegionDTO> getAllRegions() {
        return regionBoundary.findAllRegions();
    }
}
