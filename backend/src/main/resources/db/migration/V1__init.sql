CREATE TABLE usuario (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    role VARCHAR(255),
    enabled BOOLEAN
);

CREATE TABLE rol (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255)
);

CREATE TABLE producto (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    descripcion VARCHAR(255),
    precio NUMERIC(12,2),
    stock INT,
    categoria_id BIGINT,
    proveedor_id BIGINT,
    sku VARCHAR(255),
    imei_serial VARCHAR(255)
);

CREATE TABLE categoria (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    descripcion VARCHAR(255)
);

CREATE TABLE proveedor (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    telefono VARCHAR(255),
    email VARCHAR(255),
    direccion VARCHAR(255)
);

CREATE TABLE compra (
    id BIGSERIAL PRIMARY KEY,
    proveedor_id BIGINT,
    fecha TIMESTAMP,
    total NUMERIC(12,2),
    estado VARCHAR(255)
);

CREATE TABLE compra_detalle (
    id BIGSERIAL PRIMARY KEY,
    compra_id BIGINT,
    producto_id BIGINT,
    cantidad INT,
    precio_unitario NUMERIC(12,2),
    subtotal NUMERIC(12,2)
);

CREATE TABLE venta (
    id BIGSERIAL PRIMARY KEY,
    cliente_id BIGINT,
    fecha TIMESTAMP,
    total NUMERIC(12,2),
    estado VARCHAR(255)
);

CREATE TABLE venta_detalle (
    id BIGSERIAL PRIMARY KEY,
    venta_id BIGINT,
    producto_id BIGINT,
    cantidad INT,
    precio_unitario NUMERIC(12,2),
    subtotal NUMERIC(12,2)
);

CREATE TABLE inventario_movimiento (
    id BIGSERIAL PRIMARY KEY,
    producto_id BIGINT,
    tipo VARCHAR(255),
    cantidad INT,
    fecha TIMESTAMP,
    motivo VARCHAR(255)
);
