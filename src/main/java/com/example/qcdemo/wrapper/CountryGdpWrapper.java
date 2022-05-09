package com.example.qcdemo.wrapper;

import com.example.qcdemo.dto.CountryGdpDTO;
import com.example.qcdemo.dto.CountryStatsDTO;
import com.example.qcdemo.dto.GdpDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CountryGdpWrapper {
    List<GdpDTO> data;
    private Integer currentPage;
    private Long totalItems;
    private Integer totalPages;
}
