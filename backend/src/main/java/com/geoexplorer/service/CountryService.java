package com.geoexplorer.service;

import com.geoexplorer.model.Country;
import com.geoexplorer.model.CountryDto;
import com.geoexplorer.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public List<CountryDto> getAllCountries() {
        return countryRepository.findAllByOrderByNameAsc()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public CountryDto getCountryById(Long id) {
        Country c = countryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Country not found: " + id));
        return toDto(c);
    }

    private CountryDto toDto(Country c) {
        return CountryDto.builder()
                .id(c.getId())
                .name(c.getName())
                .build();
    }
}
