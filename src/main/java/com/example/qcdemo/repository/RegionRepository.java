package com.example.qcdemo.repository;

import com.example.qcdemo.entities.Region;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {

    List<Region> findByOrderByNameAsc();

}
