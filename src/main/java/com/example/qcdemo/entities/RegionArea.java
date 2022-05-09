package com.example.qcdemo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "region_areas")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class RegionArea {
    @Id
    @GeneratedValue(generator = "assigned")
    @Column(name = "region_name", nullable = false)
    private String regionName;
    @Column(name = "region_area")
    private Integer regionArea;
}
