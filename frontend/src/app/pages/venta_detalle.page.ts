import { Component } from '@angular/core';
    import { CommonModule } from '@angular/common';
    import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
    import { MatTableModule } from '@angular/material/table';
    import { MatCardModule } from '@angular/material/card';
    import { MatFormFieldModule } from '@angular/material/form-field';
    import { MatInputModule } from '@angular/material/input';
    import { MatButtonModule } from '@angular/material/button';
    import { MatCheckboxModule } from '@angular/material/checkbox';
    import { VentaDetalleService } from '../services/venta_detalle.service';

    @Component({
      selector: 'app-venta_detalle-page',
      standalone: true,
      imports: [CommonModule, ReactiveFormsModule, MatTableModule, MatCardModule, MatFormFieldModule, MatInputModule, MatButtonModule, MatCheckboxModule],
      template: `
        <mat-card class="page-card">
          <h2>VentaDetalle</h2>
          <form [formGroup]="form" (ngSubmit)="save()" class="form-grid">
            <mat-form-field appearance=\"outline\"><mat-label>ventaId</mat-label><input matInput type=\"number\" formControlName=\"ventaId\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>productoId</mat-label><input matInput type=\"number\" formControlName=\"productoId\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>cantidad</mat-label><input matInput type=\"number\" formControlName=\"cantidad\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>precioUnitario</mat-label><input matInput type=\"number\" formControlName=\"precioUnitario\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>subtotal</mat-label><input matInput type=\"number\" formControlName=\"subtotal\" /></mat-form-field>
            <button mat-raised-button color="primary">Guardar</button>
          </form>
          <table mat-table [dataSource]="items" class="mat-elevation-z1">
          <ng-container matColumnDef="id">
  <th mat-header-cell *matHeaderCellDef>id</th>
  <td mat-cell *matCellDef="let row">{{row.id}}</td>
</ng-container>
          <ng-container matColumnDef="ventaId">
  <th mat-header-cell *matHeaderCellDef>ventaId</th>
  <td mat-cell *matCellDef="let row">{{row.ventaId}}</td>
</ng-container>
          <ng-container matColumnDef="productoId">
  <th mat-header-cell *matHeaderCellDef>productoId</th>
  <td mat-cell *matCellDef="let row">{{row.productoId}}</td>
</ng-container>
          <ng-container matColumnDef="cantidad">
  <th mat-header-cell *matHeaderCellDef>cantidad</th>
  <td mat-cell *matCellDef="let row">{{row.cantidad}}</td>
</ng-container>
          <ng-container matColumnDef="precioUnitario">
  <th mat-header-cell *matHeaderCellDef>precioUnitario</th>
  <td mat-cell *matCellDef="let row">{{row.precioUnitario}}</td>
</ng-container>
          <ng-container matColumnDef="subtotal">
  <th mat-header-cell *matHeaderCellDef>subtotal</th>
  <td mat-cell *matCellDef="let row">{{row.subtotal}}</td>
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
    export class VentaDetallePage {
      items: any[] = [];
      displayedColumns = ['id', 'ventaId', 'productoId', 'cantidad', 'precioUnitario', 'subtotal', 'acciones'];
      selectedId: number | null = null;
      form = this.fb.group({
        ventaId: ['']
        productoId: ['']
        cantidad: ['']
        precioUnitario: ['']
        subtotal: ['']
      });

      constructor(private fb: FormBuilder, private service: VentaDetalleService) {
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
