package com.example.qcdemo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@NoArgsConstructor
@Getter
@Setter
public class CountryLanguageId implements Serializable{
        private Long countryId;
        private Long language;
}
