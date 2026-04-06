package com.geoexplorer.service;

import com.geoexplorer.model.City;
import com.geoexplorer.model.CityDto;
import com.geoexplorer.repository.CityRepository;
import com.geoexplorer.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public Page<CityDto> getCitiesByCountry(Long countryId, int page, int size) {
        if (!countryRepository.existsById(countryId)) {
            throw new IllegalArgumentException("Country not found: " + countryId);
        }
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("name").ascending());
        return cityRepository.findByCountryId(countryId, pageRequest).map(this::toDto);
    }

    private CityDto toDto(City c) {
        return CityDto.builder()
                .id(c.getId())
                .name(c.getName())
                .countryId(c.getCountry().getId())
                .countryName(c.getCountry().getName())
                .build();
    }
}
