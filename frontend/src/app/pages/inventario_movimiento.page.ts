import { Component } from '@angular/core';
    import { CommonModule } from '@angular/common';
    import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
    import { MatTableModule } from '@angular/material/table';
    import { MatCardModule } from '@angular/material/card';
    import { MatFormFieldModule } from '@angular/material/form-field';
    import { MatInputModule } from '@angular/material/input';
    import { MatButtonModule } from '@angular/material/button';
    import { MatCheckboxModule } from '@angular/material/checkbox';
    import { InventarioMovimientoService } from '../services/inventario_movimiento.service';

    @Component({
      selector: 'app-inventario_movimiento-page',
      standalone: true,
      imports: [CommonModule, ReactiveFormsModule, MatTableModule, MatCardModule, MatFormFieldModule, MatInputModule, MatButtonModule, MatCheckboxModule],
      template: `
        <mat-card class="page-card">
          <h2>InventarioMovimiento</h2>
          <form [formGroup]="form" (ngSubmit)="save()" class="form-grid">
            <mat-form-field appearance=\"outline\"><mat-label>productoId</mat-label><input matInput type=\"number\" formControlName=\"productoId\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>tipo</mat-label><input matInput type=\"text\" formControlName=\"tipo\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>cantidad</mat-label><input matInput type=\"number\" formControlName=\"cantidad\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>fecha</mat-label><input matInput type=\"datetime-local\" formControlName=\"fecha\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>motivo</mat-label><input matInput type=\"text\" formControlName=\"motivo\" /></mat-form-field>
            <button mat-raised-button color="primary">Guardar</button>
          </form>
          <table mat-table [dataSource]="items" class="mat-elevation-z1">
          <ng-container matColumnDef="id">
  <th mat-header-cell *matHeaderCellDef>id</th>
  <td mat-cell *matCellDef="let row">{{row.id}}</td>
</ng-container>
          <ng-container matColumnDef="productoId">
  <th mat-header-cell *matHeaderCellDef>productoId</th>
  <td mat-cell *matCellDef="let row">{{row.productoId}}</td>
</ng-container>
          <ng-container matColumnDef="tipo">
  <th mat-header-cell *matHeaderCellDef>tipo</th>
  <td mat-cell *matCellDef="let row">{{row.tipo}}</td>
</ng-container>
          <ng-container matColumnDef="cantidad">
  <th mat-header-cell *matHeaderCellDef>cantidad</th>
  <td mat-cell *matCellDef="let row">{{row.cantidad}}</td>
</ng-container>
          <ng-container matColumnDef="fecha">
  <th mat-header-cell *matHeaderCellDef>fecha</th>
  <td mat-cell *matCellDef="let row">{{row.fecha}}</td>
</ng-container>
          <ng-container matColumnDef="motivo">
  <th mat-header-cell *matHeaderCellDef>motivo</th>
  <td mat-cell *matCellDef="let row">{{row.motivo}}</td>
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
    export class InventarioMovimientoPage {
      items: any[] = [];
      displayedColumns = ['id', 'productoId', 'tipo', 'cantidad', 'fecha', 'motivo', 'acciones'];
      selectedId: number | null = null;
      form = this.fb.group({
        productoId: ['']
        tipo: ['']
        cantidad: ['']
        fecha: ['']
        motivo: ['']
      });

      constructor(private fb: FormBuilder, private service: InventarioMovimientoService) {
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
