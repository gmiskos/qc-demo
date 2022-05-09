package com.example.qcdemo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "country_stats")
@Entity
@NoArgsConstructor
@Getter
@Setter
@IdClass(StatsId.class)
public class Stats {
    @Id
    @Column(name = "country_id")
    private Long countryId;

    @Id
    @Column(name = "year")
    private Long year;

    @Column
    private Integer population;

    @Column
    private Long gdp;
}
