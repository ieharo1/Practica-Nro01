package com.example.practicanro01.controller;
import com.example.practicanro01.dto.ProveedorDto;
import com.example.practicanro01.service.ProveedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/proveedors")
public class ProveedorController {
    private final ProveedorService service;
    public ProveedorController(ProveedorService service) { this.service = service; }
    @GetMapping public List<ProveedorDto> findAll() { return service.findAll(); }
    @GetMapping("/<built-in function id>") public ProveedorDto findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping public ProveedorDto create(@RequestBody ProveedorDto dto) { return service.create(dto); }
    @PutMapping("/<built-in function id>") public ProveedorDto update(@PathVariable Long id, @RequestBody ProveedorDto dto) { return service.update(id, dto); }
    @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
