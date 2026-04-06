import { Component } from '@angular/core';
import { RouterOutlet, RouterLink } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink, MatToolbarModule],
  template: `
    <mat-toolbar class="app-toolbar">
      <a routerLink="/countries" class="brand">GeoExplorer</a>
    </mat-toolbar>
    <main class="app-main">
      <router-outlet />
    </main>
  `,
  styles: [`
    .app-toolbar {
      background: #0f172a;
      color: #f8fafc;
      box-shadow: 0 1px 0 rgba(255,255,255,0.06);
      position: sticky;
      top: 0;
      z-index: 100;
    }
    .brand {
      text-decoration: none;
      color: inherit;
      font-size: 1.2rem;
      font-weight: 500;
    }
    .app-main {
      min-height: calc(100vh - 64px);
      background: #0f172a;
    }
  `]
})
export class App {}
