package com.example.practicanro01.controller;
import com.example.practicanro01.dto.VentaDto;
import com.example.practicanro01.service.VentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    private final VentaService service;
    public VentaController(VentaService service) { this.service = service; }
    @GetMapping public List<VentaDto> findAll() { return service.findAll(); }
    @GetMapping("/<built-in function id>") public VentaDto findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping public VentaDto create(@RequestBody VentaDto dto) { return service.create(dto); }
    @PutMapping("/<built-in function id>") public VentaDto update(@PathVariable Long id, @RequestBody VentaDto dto) { return service.update(id, dto); }
    @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
