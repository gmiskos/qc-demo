package com.example.qcdemo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "continents")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Continent {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "continent_id")
    private Long continentId;

    @Column
    private String name;

    @OneToMany(mappedBy = "regionId", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Region> regions;
}
