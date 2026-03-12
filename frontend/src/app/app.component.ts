import { Component } from '@angular/core';
import { RouterOutlet, RouterLink } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
@Component({ selector: 'app-root', standalone: true, imports: [RouterOutlet, MatToolbarModule, MatButtonModule, RouterLink], template: `
<mat-toolbar color="primary"><span>Dashboard</span><span class="spacer"></span><a mat-button routerLink="/dashboard">Inicio</a><a mat-button routerLink="/login">Login</a></mat-toolbar>
<main class="app-container"><router-outlet></router-outlet></main>
`, styles: [`.app-container{padding:24px}.spacer{flex:1}`] })
export class AppComponent {}
