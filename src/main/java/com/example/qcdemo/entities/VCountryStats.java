package com.example.qcdemo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Immutable;

import javax.persistence.*;

@Table(name = "country_stats_view")
@Entity
@NoArgsConstructor
@Getter
@Setter
@Immutable
@IdClass(VStatsId.class)
public class VCountryStats {
    @Id
    @Column(name = "country_id")
    private Long countryId;

    @Id
    private Long year;

    @Column(name = "population")
    private Long population;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "region_name")
    private String regionName;

    @Column(name = "continent_name")
    private String continentName;
}
