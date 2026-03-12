import { Component } from '@angular/core';
    import { CommonModule } from '@angular/common';
    import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
    import { MatTableModule } from '@angular/material/table';
    import { MatCardModule } from '@angular/material/card';
    import { MatFormFieldModule } from '@angular/material/form-field';
    import { MatInputModule } from '@angular/material/input';
    import { MatButtonModule } from '@angular/material/button';
    import { MatCheckboxModule } from '@angular/material/checkbox';
    import { ProductoService } from '../services/producto.service';

    @Component({
      selector: 'app-producto-page',
      standalone: true,
      imports: [CommonModule, ReactiveFormsModule, MatTableModule, MatCardModule, MatFormFieldModule, MatInputModule, MatButtonModule, MatCheckboxModule],
      template: `
        <mat-card class="page-card">
          <h2>Producto</h2>
          <form [formGroup]="form" (ngSubmit)="save()" class="form-grid">
            <mat-form-field appearance=\"outline\"><mat-label>nombre</mat-label><input matInput type=\"text\" formControlName=\"nombre\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>descripcion</mat-label><input matInput type=\"text\" formControlName=\"descripcion\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>precio</mat-label><input matInput type=\"number\" formControlName=\"precio\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>stock</mat-label><input matInput type=\"number\" formControlName=\"stock\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>categoriaId</mat-label><input matInput type=\"number\" formControlName=\"categoriaId\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>proveedorId</mat-label><input matInput type=\"number\" formControlName=\"proveedorId\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>sku</mat-label><input matInput type=\"text\" formControlName=\"sku\" /></mat-form-field>
            <mat-form-field appearance=\"outline\"><mat-label>imeiSerial</mat-label><input matInput type=\"text\" formControlName=\"imeiSerial\" /></mat-form-field>
            <button mat-raised-button color="primary">Guardar</button>
          </form>
          <table mat-table [dataSource]="items" class="mat-elevation-z1">
          <ng-container matColumnDef="id">
  <th mat-header-cell *matHeaderCellDef>id</th>
  <td mat-cell *matCellDef="let row">{{row.id}}</td>
</ng-container>
          <ng-container matColumnDef="nombre">
  <th mat-header-cell *matHeaderCellDef>nombre</th>
  <td mat-cell *matCellDef="let row">{{row.nombre}}</td>
</ng-container>
          <ng-container matColumnDef="descripcion">
  <th mat-header-cell *matHeaderCellDef>descripcion</th>
  <td mat-cell *matCellDef="let row">{{row.descripcion}}</td>
</ng-container>
          <ng-container matColumnDef="precio">
  <th mat-header-cell *matHeaderCellDef>precio</th>
  <td mat-cell *matCellDef="let row">{{row.precio}}</td>
</ng-container>
          <ng-container matColumnDef="stock">
  <th mat-header-cell *matHeaderCellDef>stock</th>
  <td mat-cell *matCellDef="let row">{{row.stock}}</td>
</ng-container>
          <ng-container matColumnDef="categoriaId">
  <th mat-header-cell *matHeaderCellDef>categoriaId</th>
  <td mat-cell *matCellDef="let row">{{row.categoriaId}}</td>
</ng-container>
          <ng-container matColumnDef="proveedorId">
  <th mat-header-cell *matHeaderCellDef>proveedorId</th>
  <td mat-cell *matCellDef="let row">{{row.proveedorId}}</td>
</ng-container>
          <ng-container matColumnDef="sku">
  <th mat-header-cell *matHeaderCellDef>sku</th>
  <td mat-cell *matCellDef="let row">{{row.sku}}</td>
</ng-container>
          <ng-container matColumnDef="imeiSerial">
  <th mat-header-cell *matHeaderCellDef>imeiSerial</th>
  <td mat-cell *matCellDef="let row">{{row.imeiSerial}}</td>
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
    export class ProductoPage {
      items: any[] = [];
      displayedColumns = ['id', 'nombre', 'descripcion', 'precio', 'stock', 'categoriaId', 'proveedorId', 'sku', 'imeiSerial', 'acciones'];
      selectedId: number | null = null;
      form = this.fb.group({
        nombre: ['']
        descripcion: ['']
        precio: ['']
        stock: ['']
        categoriaId: ['']
        proveedorId: ['']
        sku: ['']
        imeiSerial: ['']
      });

      constructor(private fb: FormBuilder, private service: ProductoService) {
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
