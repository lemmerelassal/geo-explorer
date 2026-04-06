package com.geoexplorer.controller;

import com.geoexplorer.model.CityDto;
import com.geoexplorer.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Cities", description = "Endpoints for city data")
public class CityController {

    private final CityService cityService;

    @GetMapping("/api/countries/{countryId}/cities")
    @Operation(
        summary = "List cities by country (paginated)",
        description = "Returns a paginated list of cities for the given country. Default page size is 5."
    )
    public ResponseEntity<Page<CityDto>> getCitiesByCountry(
            @Parameter(description = "Country ID") @PathVariable Long countryId,
            @Parameter(description = "Page number (0-based)") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Page size") @RequestParam(defaultValue = "5") int size) {
        try {
            return ResponseEntity.ok(cityService.getCitiesByCountry(countryId, page, size));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
