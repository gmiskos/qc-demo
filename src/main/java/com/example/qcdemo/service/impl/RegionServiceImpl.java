package com.example.qcdemo.service.impl;

import com.example.qcdemo.entities.Region;
import com.example.qcdemo.repository.RegionRepository;
import com.example.qcdemo.service.RegionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
@Primary
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionRepository regionRepository;


    @Override
    public List<Region> findAllRegions() {
        return regionRepository.findByOrderByNameAsc();
    }
}
