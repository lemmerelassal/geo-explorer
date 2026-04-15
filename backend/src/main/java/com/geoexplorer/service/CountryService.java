package com.geoexplorer.service;

import com.geoexplorer.model.Country;
import com.geoexplorer.model.CountryDto;
import com.geoexplorer.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public Page<CountryDto> getAllCountries(Pageable pageable) {
        return countryRepository.findAllByOrderByNameAsc(pageable).map(this::toDto);
    }

    public CountryDto getCountryById(Long id) {
        Country c = countryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Country not found: " + id));
        return toDto(c);
    }

    private CountryDto toDto(Country c) {
        return new CountryDto(c.getId(), c.getName());
    }
}
