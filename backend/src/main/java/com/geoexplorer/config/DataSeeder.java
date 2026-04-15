package com.geoexplorer.config;

import com.geoexplorer.model.City;
import com.geoexplorer.model.Country;
import com.geoexplorer.repository.CityRepository;
import com.geoexplorer.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSeeder implements CommandLineRunner {

    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    @Override
    public void run(String... args) {
        if (countryRepository.count() > 0) return;

        Country france    = countryRepository.save(Country.builder().name("France").build());
        Country germany   = countryRepository.save(Country.builder().name("Germany").build());
        Country japan     = countryRepository.save(Country.builder().name("Japan").build());
        Country brazil    = countryRepository.save(Country.builder().name("Brazil").build());
        Country usa       = countryRepository.save(Country.builder().name("United States").build());
        Country india     = countryRepository.save(Country.builder().name("India").build());
        Country australia = countryRepository.save(Country.builder().name("Australia").build());
        Country nigeria   = countryRepository.save(Country.builder().name("Nigeria").build());
        Country luxembourg = countryRepository.save(Country.builder().name("Luxembourg").build());

        cityRepository.saveAll(List.of(
            City.builder().name("Paris").country(france).build(),
            City.builder().name("Lyon").country(france).build(),
            City.builder().name("Marseille").country(france).build(),
            City.builder().name("Bordeaux").country(france).build(),
            City.builder().name("Toulouse").country(france).build(),
            City.builder().name("Nice").country(france).build(),
            City.builder().name("Nantes").country(france).build(),

            City.builder().name("Berlin").country(germany).build(),
            City.builder().name("Munich").country(germany).build(),
            City.builder().name("Hamburg").country(germany).build(),
            City.builder().name("Cologne").country(germany).build(),
            City.builder().name("Frankfurt").country(germany).build(),
            City.builder().name("Stuttgart").country(germany).build(),
            City.builder().name("Dresden").country(germany).build(),

            City.builder().name("Tokyo").country(japan).build(),
            City.builder().name("Osaka").country(japan).build(),
            City.builder().name("Kyoto").country(japan).build(),
            City.builder().name("Sapporo").country(japan).build(),
            City.builder().name("Hiroshima").country(japan).build(),
            City.builder().name("Fukuoka").country(japan).build(),
            City.builder().name("Nagoya").country(japan).build(),

            City.builder().name("Brasília").country(brazil).build(),
            City.builder().name("São Paulo").country(brazil).build(),
            City.builder().name("Rio de Janeiro").country(brazil).build(),
            City.builder().name("Salvador").country(brazil).build(),
            City.builder().name("Fortaleza").country(brazil).build(),
            City.builder().name("Manaus").country(brazil).build(),
            City.builder().name("Curitiba").country(brazil).build(),

            City.builder().name("Washington D.C.").country(usa).build(),
            City.builder().name("New York City").country(usa).build(),
            City.builder().name("Los Angeles").country(usa).build(),
            City.builder().name("Chicago").country(usa).build(),
            City.builder().name("Houston").country(usa).build(),
            City.builder().name("Miami").country(usa).build(),
            City.builder().name("Seattle").country(usa).build(),

            City.builder().name("New Delhi").country(india).build(),
            City.builder().name("Mumbai").country(india).build(),
            City.builder().name("Bangalore").country(india).build(),
            City.builder().name("Chennai").country(india).build(),
            City.builder().name("Kolkata").country(india).build(),
            City.builder().name("Jaipur").country(india).build(),
            City.builder().name("Hyderabad").country(india).build(),

            City.builder().name("Canberra").country(australia).build(),
            City.builder().name("Sydney").country(australia).build(),
            City.builder().name("Melbourne").country(australia).build(),
            City.builder().name("Brisbane").country(australia).build(),
            City.builder().name("Perth").country(australia).build(),
            City.builder().name("Adelaide").country(australia).build(),
            City.builder().name("Darwin").country(australia).build(),

            City.builder().name("Abuja").country(nigeria).build(),
            City.builder().name("Lagos").country(nigeria).build(),
            City.builder().name("Kano").country(nigeria).build(),
            City.builder().name("Ibadan").country(nigeria).build(),
            City.builder().name("Port Harcourt").country(nigeria).build(),
            City.builder().name("Benin City").country(nigeria).build(),
            City.builder().name("Kaduna").country(nigeria).build(),


            City.builder().name("Luxembourg").country(luxembourg).build(),
            City.builder().name("Esch-sur-Alzette").country(luxembourg).build(),
            City.builder().name("Differdange").country(luxembourg).build(),
            City.builder().name("Dudelange").country(luxembourg).build(),
            City.builder().name("Bettembourg").country(luxembourg).build(),
            City.builder().name("Pétange").country(luxembourg).build(),
            City.builder().name("Strassen").country(luxembourg).build()
        ));

        log.info("Seeded {} countries, {} cities.", countryRepository.count(), cityRepository.count());
    }
}
