package com.example.qcdemo.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "countries")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "country_id")
    private Long countryId;

    @Column
    private String name;

    @Column
    private Integer area;

    @Column(name = "national_day")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyy")
    private Date nationalDay;

    @Column(name = "country_code2")
    private String countryCode2;

    @Column(name = "country_code3")
    private String countryCode3;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "countryId")
    private Set<CountryLanguage> languages = new HashSet<>();

    //TODO ONE TO MANY COUNTRY STATS
    @OneToMany(mappedBy = "countryId", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Stats> stats;
}
