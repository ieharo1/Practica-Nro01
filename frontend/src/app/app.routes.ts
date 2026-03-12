import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
  { path: 'dashboard', loadComponent: () => import('./pages/dashboard.page').then(m => m.DashboardPage) },
  { path: 'login', loadComponent: () => import('./pages/login.page').then(m => m.LoginPage) },
  { path: 'usuario', loadComponent: () => import('./pages/usuario.page').then(m => m.UsuarioPage) },
  { path: 'rol', loadComponent: () => import('./pages/rol.page').then(m => m.RolPage) },
  { path: 'producto', loadComponent: () => import('./pages/producto.page').then(m => m.ProductoPage) },
  { path: 'categoria', loadComponent: () => import('./pages/categoria.page').then(m => m.CategoriaPage) },
  { path: 'proveedor', loadComponent: () => import('./pages/proveedor.page').then(m => m.ProveedorPage) },
  { path: 'compra', loadComponent: () => import('./pages/compra.page').then(m => m.CompraPage) },
  { path: 'compra_detalle', loadComponent: () => import('./pages/compra_detalle.page').then(m => m.CompraDetallePage) },
  { path: 'venta', loadComponent: () => import('./pages/venta.page').then(m => m.VentaPage) },
  { path: 'venta_detalle', loadComponent: () => import('./pages/venta_detalle.page').then(m => m.VentaDetallePage) },
  { path: 'inventario_movimiento', loadComponent: () => import('./pages/inventario_movimiento.page').then(m => m.InventarioMovimientoPage) },
  { path: '**', redirectTo: 'dashboard' }
];
