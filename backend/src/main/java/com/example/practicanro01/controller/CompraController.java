package com.example.practicanro01.controller;
import com.example.practicanro01.dto.CompraDto;
import com.example.practicanro01.service.CompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/compras")
public class CompraController {
    private final CompraService service;
    public CompraController(CompraService service) { this.service = service; }
    @GetMapping public List<CompraDto> findAll() { return service.findAll(); }
    @GetMapping("/<built-in function id>") public CompraDto findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping public CompraDto create(@RequestBody CompraDto dto) { return service.create(dto); }
    @PutMapping("/<built-in function id>") public CompraDto update(@PathVariable Long id, @RequestBody CompraDto dto) { return service.update(id, dto); }
    @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
