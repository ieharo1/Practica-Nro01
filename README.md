# Sistema de Gestion para Ferreteria (Spring Boot + Angular)

    Sistema completo de gestion con API REST segura, dashboard basico y modulos operativos.

    ---

    ## ✅ Descripcion

    Plataforma web con backend Java 21 + Spring Boot 3, autenticacion JWT, base de datos PostgreSQL y frontend Angular 17 con Angular Material.

    ---

    ## ✨ Caracteristicas Principales

    | Caracteristica | Descripcion |
    |----------------|-------------|
    | **Inventario** | Modulo operativo |
| **Categorias** | Modulo operativo |
| **Proveedores** | Modulo operativo |
| **Compras** | Modulo operativo |
| **Ventas** | Modulo operativo |
| **Alertas de stock** | Modulo operativo |

    ---

    ## 📦 Modulos

    - **Inventario**
- **Categorias**
- **Proveedores**
- **Compras**
- **Ventas**
- **Alertas de stock**

    ---

    ## 📑 Entidades

    - **Usuario**
- **Rol**
- **Producto**
- **Categoria**
- **Proveedor**
- **Compra**
- **CompraDetalle**
- **Venta**
- **VentaDetalle**
- **InventarioMovimiento**

    ---

    ## ⚙️ Funciones

    - **stock minimo**
- **historial de ventas**
- **dashboard ventas**
- **control proveedores**

    ---

    ## 🧰 Stack Tecnologico

    - Java 21 + Spring Boot 3
    - Spring Security + JWT
    - Spring Data JPA + Hibernate
    - Flyway
    - PostgreSQL
    - Angular 17 + Angular Material
    - Docker + Docker Compose

    ---

    ## 🏗️ Arquitectura

    Separacion por capas y modulos:

    1. Backend: controller, service, repository, entity, dto, security, config
    2. Frontend: pages, components, services, models, guards
    3. Infra: Docker y Docker Compose

    ---

    ## ✅ Instalacion y Uso

    ```bash
    docker compose up --build
    ```

    - Frontend: http://localhost:4200
    - Backend API: http://localhost:8080

    ---

    ## 🔌 API REST

    - `POST /api/auth/register`
    - `POST /api/auth/login`
    - `GET /api/{entidad}s`
    - `POST /api/{entidad}s`
    - `PUT /api/{entidad}s/{id}`
    - `DELETE /api/{entidad}s/{id}`

    ---

    ## 📁 Estructura del Proyecto

    ```
    project/
    ├── docker-compose.yml
    ├── backend/
    └── frontend/
    ```

    ---

    ## 👨‍💻 Desarrollado por Isaac Esteban Haro Torres

    Ingeniero en Sistemas - Full Stack - Automatizacion - Data

    - Email: zackharo1@gmail.com
    - WhatsApp: 098805517
    - GitHub: https://github.com/ieharo1
    - Portafolio: https://ieharo1.github.io/portafolio-isaac.haro/

    ---

    (C) 2026 Isaac Esteban Haro Torres - Todos los derechos reservados.
