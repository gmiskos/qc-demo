package com.example.qcdemo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "country_languages")
@Entity
@NoArgsConstructor
@Getter
@Setter
@IdClass(CountryLanguageId.class)
public class CountryLanguage implements Serializable {

    @Id
    @Column(name = "country_id")
    private Long countryId;

//    @Id
//    @Column(name = "language_id")
//    private Long languageId;
    @Id
    @ManyToOne(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "language_id")
    private Language language;

    @Column(name = "official")
    private Integer official;

}
