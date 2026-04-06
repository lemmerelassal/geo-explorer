export interface Country {
  id: number;
  name: string;
}

export interface City {
  id: number;
  name: string;
  countryId: number;
  countryName: string;
}

export interface PagedResponse<T> {
  content: T[];
  totalElements: number;
  totalPages: number;
  size: number;
  number: number;
}
