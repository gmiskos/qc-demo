package com.example.qcdemo.wrapper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StatsRequestWrapper {
    private String regionName;
    private int yearFrom;
    private int yearTo;
    private int page;
    private int size;
}
