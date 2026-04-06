import { Component, OnInit, inject, signal } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MatListModule } from '@angular/material/list';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { GeoService } from '../../services/geo.service';
import { Country } from '../../models/geo.models';

@Component({
  selector: 'app-country-list',
  standalone: true,
  imports: [CommonModule, MatListModule, MatProgressSpinnerModule],
  templateUrl: './country-list.component.html',
  styleUrl: './country-list.component.scss'
})
export class CountryListComponent implements OnInit {
  private geoService = inject(GeoService);
  private router = inject(Router);

  countries = signal<Country[]>([]);
  loading = signal(true);

  ngOnInit() {
    this.geoService.getCountries().subscribe({
      next: (data) => { this.countries.set(data); this.loading.set(false); },
      error: () => this.loading.set(false)
    });
  }

  selectCountry(country: Country) {
    this.router.navigate(['/countries', country.id, 'cities']);
  }
}
