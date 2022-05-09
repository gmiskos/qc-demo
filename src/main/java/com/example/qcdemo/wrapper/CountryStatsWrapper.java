package com.example.qcdemo.wrapper;

import com.example.qcdemo.dto.CountryStatsDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CountryStatsWrapper {
    List<CountryStatsDTO> data;
    private Integer currentPage;
    private Long totalItems;
    private Integer totalPages;
}
