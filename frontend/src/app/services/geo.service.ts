import { Injectable, inject } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Country, City, PagedResponse } from '../models/geo.models';

@Injectable({ providedIn: 'root' })
export class GeoService {
  private readonly http = inject(HttpClient);
  private readonly base = '/api';

  getCountries(): Observable<Country[]> {
    return this.http.get<Country[]>(`${this.base}/countries`);
  }

  getCountry(id: number): Observable<Country> {
    return this.http.get<Country>(`${this.base}/countries/${id}`);
  }

  getCities(countryId: number, page = 0, size = 5): Observable<PagedResponse<City>> {
    const params = new HttpParams().set('page', page).set('size', size);
    return this.http.get<PagedResponse<City>>(`${this.base}/countries/${countryId}/cities`, { params });
  }
}
