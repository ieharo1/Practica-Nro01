package com.example.practicanro01.entity;
    import jakarta.persistence.*;
    import java.math.BigDecimal;
import java.time.LocalDateTime;

    @Entity
    @Table(name = "venta")
    public class Venta {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clienteId;
    private LocalDateTime fecha;
    private BigDecimal total;
    private String estado;

        public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    }
