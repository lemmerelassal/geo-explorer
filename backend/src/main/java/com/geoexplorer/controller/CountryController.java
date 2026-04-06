package com.geoexplorer.controller;

import com.geoexplorer.model.CountryDto;
import com.geoexplorer.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
@Tag(name = "Countries", description = "Endpoints for country data")
@CrossOrigin(origins = "*")
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    @Operation(
        summary = "List all countries",
        description = "Returns all countries sorted alphabetically",
        responses = {
            @ApiResponse(responseCode = "200", description = "Success",
                content = @Content(array = @ArraySchema(schema = @Schema(implementation = CountryDto.class))))
        }
    )
    public ResponseEntity<List<CountryDto>> getAllCountries() {
        return ResponseEntity.ok(countryService.getAllCountries());
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Get a country by ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Found"),
            @ApiResponse(responseCode = "404", description = "Not found")
        }
    )
    public ResponseEntity<CountryDto> getCountry(
            @Parameter(description = "Country ID") @PathVariable Long id) {
        try {
            return ResponseEntity.ok(countryService.getCountryById(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
