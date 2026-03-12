package com.example.practicanro01.controller;
import com.example.practicanro01.dto.VentaDetalleDto;
import com.example.practicanro01.service.VentaDetalleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/venta_detalles")
public class VentaDetalleController {
    private final VentaDetalleService service;
    public VentaDetalleController(VentaDetalleService service) { this.service = service; }
    @GetMapping public List<VentaDetalleDto> findAll() { return service.findAll(); }
    @GetMapping("/<built-in function id>") public VentaDetalleDto findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping public VentaDetalleDto create(@RequestBody VentaDetalleDto dto) { return service.create(dto); }
    @PutMapping("/<built-in function id>") public VentaDetalleDto update(@PathVariable Long id, @RequestBody VentaDetalleDto dto) { return service.update(id, dto); }
    @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
