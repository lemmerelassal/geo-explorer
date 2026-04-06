package com.geoexplorer.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryDto {
    private Long id;
    private String name;
}
