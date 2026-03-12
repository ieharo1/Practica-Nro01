package com.example.practicanro01.dto;
import java.math.BigDecimal;

public class CompraDetalleDto {
        private Long id;
    private Long compraId;
    private Long productoId;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;

    public Long getId() { return id; }
public void setId(Long id) { this.id = id; }

public Long getCompraId() { return compraId; }
public void setCompraId(Long compraId) { this.compraId = compraId; }

public Long getProductoId() { return productoId; }
public void setProductoId(Long productoId) { this.productoId = productoId; }

public Integer getCantidad() { return cantidad; }
public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

public BigDecimal getPrecioUnitario() { return precioUnitario; }
public void setPrecioUnitario(BigDecimal precioUnitario) { this.precioUnitario = precioUnitario; }

public BigDecimal getSubtotal() { return subtotal; }
public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
}
