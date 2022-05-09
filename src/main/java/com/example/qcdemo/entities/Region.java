package com.example.qcdemo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "regions")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Region {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "region_id")
    private Long regionId;

    @Column
    private String name;

    @Column(name = "continent_id")
    private Long continentId;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "countryId",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Country> countries;
}
