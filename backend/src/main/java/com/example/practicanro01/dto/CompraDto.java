package com.example.practicanro01.dto;
    import java.math.BigDecimal;
import java.time.LocalDateTime;

    public class CompraDto {
            private Long id;
        private Long proveedorId;
        private LocalDateTime fecha;
        private BigDecimal total;
        private String estado;

        public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getProveedorId() { return proveedorId; }
    public void setProveedorId(Long proveedorId) { this.proveedorId = proveedorId; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    }
