import { Component } from '@angular/core';
    import { CommonModule } from '@angular/common';
    import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
    import { MatTableModule } from '@angular/material/table';
    import { MatCardModule } from '@angular/material/card';
    import { MatFormFieldModule } from '@angular/material/form-field';
    import { MatInputModule } from '@angular/material/input';
    import { MatButtonModule } from '@angular/material/button';
    import { MatCheckboxModule } from '@angular/material/checkbox';
    import { UsuarioService } from '../services/usuario.service';

    @Component({
      selector: 'app-usuario-page',
      standalone: true,
      imports: [CommonModule, ReactiveFormsModule, MatTableModule, MatCardModule, MatFormFieldModule, MatInputModule, MatButtonModule, MatCheckboxModule],
      template: `
        <mat-card class="page-card">
          <h2>Usuario</h2>
          <form [formGroup]="form" (ngSubmit)="save()" class="form-grid">
            <mat-form-field appearance=\"outline\"><mat-label>username</mat-label><input matInput type=\"text\" formControlName=\"username\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>password</mat-label><input matInput type=\"text\" formControlName=\"password\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>role</mat-label><input matInput type=\"text\" formControlName=\"role\" /></mat-form-field>
            <mat-checkbox formControlName=\"enabled\">enabled</mat-checkbox>
            <button mat-raised-button color="primary">Guardar</button>
          </form>
          <table mat-table [dataSource]="items" class="mat-elevation-z1">
          <ng-container matColumnDef="id">
  <th mat-header-cell *matHeaderCellDef>id</th>
  <td mat-cell *matCellDef="let row">{{row.id}}</td>
</ng-container>
          <ng-container matColumnDef="username">
  <th mat-header-cell *matHeaderCellDef>username</th>
  <td mat-cell *matCellDef="let row">{{row.username}}</td>
</ng-container>
          <ng-container matColumnDef="password">
  <th mat-header-cell *matHeaderCellDef>password</th>
  <td mat-cell *matCellDef="let row">{{row.password}}</td>
</ng-container>
          <ng-container matColumnDef="role">
  <th mat-header-cell *matHeaderCellDef>role</th>
  <td mat-cell *matCellDef="let row">{{row.role}}</td>
</ng-container>
          <ng-container matColumnDef="enabled">
  <th mat-header-cell *matHeaderCellDef>enabled</th>
  <td mat-cell *matCellDef="let row">{{row.enabled}}</td>
</ng-container>
          <ng-container matColumnDef="acciones">
  <th mat-header-cell *matHeaderCellDef>Acciones</th>
  <td mat-cell *matCellDef="let row">
    <button mat-button color="primary" (click)="edit(row)">Editar</button>
    <button mat-button color="warn" (click)="remove(row.id)">Eliminar</button>
  </td>
</ng-container>
            <tr mat-header-row *matHeaderRowDef="displayedColumns"></tr>
            <tr mat-row *matRowDef="let row; columns: displayedColumns;"></tr>
          </table>
        </mat-card>
      `,
      styles: [`.page-card { padding: 20px; display: grid; gap: 16px; }`, `.form-grid { display: grid; gap: 12px; grid-template-columns: repeat(auto-fit, minmax(220px, 1fr)); }`, `table { width: 100%; }`]
    })
    export class UsuarioPage {
      items: any[] = [];
      displayedColumns = ['id', 'username', 'password', 'role', 'enabled', 'acciones'];
      selectedId: number | null = null;
      form = this.fb.group({
        username: ['']
        password: ['']
        role: ['']
        enabled: ['']
      });

      constructor(private fb: FormBuilder, private service: UsuarioService) {
        this.load();
      }

      load() {
        this.service.findAll().subscribe(data => (this.items = data));
      }

      edit(row: any) {
        this.selectedId = row.id;
        this.form.patchValue(row);
      }

      save() {
        const payload = this.form.value;
        if (this.selectedId) {
          this.service.update(this.selectedId, payload).subscribe(() => { this.selectedId = null; this.form.reset(); this.load(); });
        } else {
          this.service.create(payload).subscribe(() => { this.form.reset(); this.load(); });
        }
      }

      remove(id: number) {
        this.service.delete(id).subscribe(() => this.load());
      }
    }
