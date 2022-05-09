package com.example.qcdemo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "languages")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Language {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "language_id")
    private Long languageId;

    @Column(name = "language")
    private String language;
}
