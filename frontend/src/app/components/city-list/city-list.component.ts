import { Component, OnInit, inject, signal } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MatListModule } from '@angular/material/list';
import { MatPaginatorModule, PageEvent } from '@angular/material/paginator';
import { MatButtonModule } from '@angular/material/button';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { GeoService } from '../../services/geo.service';
import { City, Country } from '../../models/geo.models';

@Component({
  selector: 'app-city-list',
  standalone: true,
  imports: [CommonModule, MatListModule, MatPaginatorModule, MatButtonModule, MatProgressSpinnerModule],
  templateUrl: './city-list.component.html',
  styleUrl: './city-list.component.scss'
})
export class CityListComponent implements OnInit {
  private route = inject(ActivatedRoute);
  private router = inject(Router);
  private geoService = inject(GeoService);

  cities = signal<City[]>([]);
  country = signal<Country | null>(null);
  loading = signal(true);
  totalElements = signal(0);
  pageSize = 5;
  pageIndex = signal(0);
  countryId!: number;

  ngOnInit() {
    this.countryId = Number(this.route.snapshot.paramMap.get('countryId'));
    this.geoService.getCountry(this.countryId).subscribe(c => this.country.set(c));
    this.loadCities(0);
  }

  loadCities(page: number) {
    this.loading.set(true);
    this.geoService.getCities(this.countryId, page, this.pageSize).subscribe({
      next: (resp) => {
        this.cities.set(resp.content);
        this.totalElements.set(resp.totalElements);
        this.loading.set(false);
      },
      error: () => this.loading.set(false)
    });
  }

  onPageChange(event: PageEvent) {
    this.pageIndex.set(event.pageIndex);
    this.loadCities(event.pageIndex);
  }

  goBack() {
    this.router.navigate(['/countries']);
  }
}
