package com.example.practicanro01.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nombre;
private String descripcion;
private BigDecimal precio;
private Integer stock;
private Long categoriaId;
private Long proveedorId;
private String sku;
private String imeiSerial;

    public Long getId() { return id; }
public void setId(Long id) { this.id = id; }

public String getNombre() { return nombre; }
public void setNombre(String nombre) { this.nombre = nombre; }

public String getDescripcion() { return descripcion; }
public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

public BigDecimal getPrecio() { return precio; }
public void setPrecio(BigDecimal precio) { this.precio = precio; }

public Integer getStock() { return stock; }
public void setStock(Integer stock) { this.stock = stock; }

public Long getCategoriaId() { return categoriaId; }
public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }

public Long getProveedorId() { return proveedorId; }
public void setProveedorId(Long proveedorId) { this.proveedorId = proveedorId; }

public String getSku() { return sku; }
public void setSku(String sku) { this.sku = sku; }

public String getImeiSerial() { return imeiSerial; }
public void setImeiSerial(String imeiSerial) { this.imeiSerial = imeiSerial; }
}
