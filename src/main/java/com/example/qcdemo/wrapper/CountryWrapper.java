package com.example.qcdemo.wrapper;

import com.example.qcdemo.dto.CountryDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CountryWrapper {
    List<CountryDTO> countries;
    private Integer currentPage;
    private Long totalItems;
    private Integer totalPages;
}
