package com.example.practicanro01.controller;
import com.example.practicanro01.dto.CompraDetalleDto;
import com.example.practicanro01.service.CompraDetalleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/compra_detalles")
public class CompraDetalleController {
    private final CompraDetalleService service;
    public CompraDetalleController(CompraDetalleService service) { this.service = service; }
    @GetMapping public List<CompraDetalleDto> findAll() { return service.findAll(); }
    @GetMapping("/<built-in function id>") public CompraDetalleDto findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping public CompraDetalleDto create(@RequestBody CompraDetalleDto dto) { return service.create(dto); }
    @PutMapping("/<built-in function id>") public CompraDetalleDto update(@PathVariable Long id, @RequestBody CompraDetalleDto dto) { return service.update(id, dto); }
    @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
