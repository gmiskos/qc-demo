package com.example.qcdemo.repository;

import com.example.qcdemo.dto.CountryGdpDTO;
import com.example.qcdemo.entities.Country;
import com.example.qcdemo.entities.Stats;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StatsRepository extends JpaRepository<Stats, Long> {

    @Query(value = "SELECT c.countryId as countryId, c.name as name, c.countryCode3 as countryCode3, cs.year as year, cs.population as population, max(cs.gdp/cs.population) as gdpPerPopulation "
            + " FROM Stats cs "
            +" left join Country c on c.countryId = cs.countryId "
            +" GROUP BY c.countryId ORDER BY gdpPerPopulation DESC")
    Page<CountryGdpDTO> findCountryGdp(Pageable pageable);

}
