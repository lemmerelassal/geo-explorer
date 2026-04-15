package com.geoexplorer.service;

import com.geoexplorer.model.City;
import com.geoexplorer.model.CityDto;
import com.geoexplorer.repository.CityRepository;
import com.geoexplorer.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public Page<CityDto> getCitiesByCountry(Long countryId, Pageable pageable) {
        if (!countryRepository.existsById(countryId)) {
            throw new IllegalArgumentException("Country not found: " + countryId);
        }
        return cityRepository.findByCountryId(countryId, pageable).map(this::toDto);
    }

    private CityDto toDto(City c) {
        return new CityDto(c.getId(), c.getName(), c.getCountry().getId(), c.getCountry().getName());
    }
}
