package com.example.qcdemo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "guests")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Guest {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "guest_id")
    private Long continentId;

    @Column
    private String name;
}
