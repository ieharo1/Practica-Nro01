package com.example.practicanro01.controller;
import com.example.practicanro01.dto.ProductoDto;
import com.example.practicanro01.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoService service;
    public ProductoController(ProductoService service) { this.service = service; }
    @GetMapping public List<ProductoDto> findAll() { return service.findAll(); }
    @GetMapping("/<built-in function id>") public ProductoDto findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping public ProductoDto create(@RequestBody ProductoDto dto) { return service.create(dto); }
    @PutMapping("/<built-in function id>") public ProductoDto update(@PathVariable Long id, @RequestBody ProductoDto dto) { return service.update(id, dto); }
    @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
