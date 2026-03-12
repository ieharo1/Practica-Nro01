package com.example.practicanro01.controller;
import com.example.practicanro01.dto.InventarioMovimientoDto;
import com.example.practicanro01.service.InventarioMovimientoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/inventario_movimientos")
public class InventarioMovimientoController {
    private final InventarioMovimientoService service;
    public InventarioMovimientoController(InventarioMovimientoService service) { this.service = service; }
    @GetMapping public List<InventarioMovimientoDto> findAll() { return service.findAll(); }
    @GetMapping("/<built-in function id>") public InventarioMovimientoDto findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping public InventarioMovimientoDto create(@RequestBody InventarioMovimientoDto dto) { return service.create(dto); }
    @PutMapping("/<built-in function id>") public InventarioMovimientoDto update(@PathVariable Long id, @RequestBody InventarioMovimientoDto dto) { return service.update(id, dto); }
    @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
