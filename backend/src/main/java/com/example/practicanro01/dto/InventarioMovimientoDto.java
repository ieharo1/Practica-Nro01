package com.example.practicanro01.dto;
import java.time.LocalDateTime;

public class InventarioMovimientoDto {
        private Long id;
    private Long productoId;
    private String tipo;
    private Integer cantidad;
    private LocalDateTime fecha;
    private String motivo;

    public Long getId() { return id; }
public void setId(Long id) { this.id = id; }

public Long getProductoId() { return productoId; }
public void setProductoId(Long productoId) { this.productoId = productoId; }

public String getTipo() { return tipo; }
public void setTipo(String tipo) { this.tipo = tipo; }

public Integer getCantidad() { return cantidad; }
public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

public LocalDateTime getFecha() { return fecha; }
public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

public String getMotivo() { return motivo; }
public void setMotivo(String motivo) { this.motivo = motivo; }
}
