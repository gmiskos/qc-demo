package com.example.qcdemo.service.impl;

import com.example.qcdemo.dto.CountryStatsDTO;
import com.example.qcdemo.entities.VCountryStats;
import com.example.qcdemo.repository.CountryStatsRepository;
import com.example.qcdemo.service.VCountryStatsService;
import com.example.qcdemo.wrapper.CountryStatsWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
@Primary
public class VCountryStatsServiceImpl implements VCountryStatsService {

    @Autowired
    CountryStatsRepository countryStatsRepository;

    private final EntityManager entityManager;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public CountryStatsWrapper searchCountryStats(String regionName, Integer yearFrom, Integer yearTo, Pageable paging) {
        CountryStatsWrapper wrapper = new CountryStatsWrapper();

        //count
        CriteriaBuilder countCriteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = countCriteriaBuilder.createQuery(Long.class);
        Root<VCountryStats> root = countQuery.from(VCountryStats.class);
        countQuery.select(countCriteriaBuilder.count(root));

        //data
        CriteriaBuilder dataCriteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<VCountryStats> dataQuery = dataCriteriaBuilder.createQuery(VCountryStats.class);
        Root<VCountryStats> statsRoot = dataQuery.from(VCountryStats.class);

        //filtesr
        List<Predicate> countPredicates = new ArrayList<>();
        List<Predicate> dataPredicates = new ArrayList<>();
        if (regionName != null) {
            dataPredicates.add(dataCriteriaBuilder.equal(statsRoot.get("regionName"), regionName));
            countPredicates.add(countCriteriaBuilder.equal(root.get("regionName"), regionName));
        }
        countQuery.where(countPredicates.toArray(new Predicate[0]));
        dataQuery.where(dataPredicates.toArray(new Predicate[0]));

        Long totalResults = entityManager.createQuery(countQuery).getSingleResult();

        List<VCountryStats> countryStats = entityManager.createQuery(dataQuery)
        .setMaxResults(paging.getPageSize())
        .setFirstResult(paging.getPageNumber())
        .getResultList();
        List<CountryStatsDTO> countryStatsDTOS = countryStats.stream().map(this::convertToCountryStatsDto)
                .collect(Collectors.toList());

        wrapper.setData(countryStatsDTOS);
        wrapper.setTotalItems(totalResults);
        wrapper.setTotalPages((int) (totalResults/paging.getPageSize()));
        wrapper.setCurrentPage(paging.getPageNumber());
        return wrapper;
    }

    private CountryStatsDTO convertToCountryStatsDto(VCountryStats countryStats) {
        CountryStatsDTO countryStatsDTO = modelMapper.map(countryStats, CountryStatsDTO.class);
        return countryStatsDTO;
    }

}
