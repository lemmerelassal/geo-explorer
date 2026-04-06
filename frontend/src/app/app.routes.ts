import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: '', redirectTo: 'countries', pathMatch: 'full' },
  {
    path: 'countries',
    loadComponent: () =>
      import('./components/country-list/country-list.component').then(m => m.CountryListComponent)
  },
  {
    path: 'countries/:countryId/cities',
    loadComponent: () =>
      import('./components/city-list/city-list.component').then(m => m.CityListComponent)
  },
  { path: '**', redirectTo: 'countries' }
];
