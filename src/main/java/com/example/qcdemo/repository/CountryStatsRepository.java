package com.example.qcdemo.repository;

import com.example.qcdemo.entities.VCountryStats;
import com.example.qcdemo.entities.VStatsId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryStatsRepository extends JpaRepository<VCountryStats, VStatsId> {

    Page<VCountryStats> findAll(Pageable pageable);

}
