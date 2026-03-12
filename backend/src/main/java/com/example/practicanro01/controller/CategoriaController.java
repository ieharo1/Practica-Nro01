package com.example.practicanro01.controller;
import com.example.practicanro01.dto.CategoriaDto;
import com.example.practicanro01.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    private final CategoriaService service;
    public CategoriaController(CategoriaService service) { this.service = service; }
    @GetMapping public List<CategoriaDto> findAll() { return service.findAll(); }
    @GetMapping("/<built-in function id>") public CategoriaDto findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping public CategoriaDto create(@RequestBody CategoriaDto dto) { return service.create(dto); }
    @PutMapping("/<built-in function id>") public CategoriaDto update(@PathVariable Long id, @RequestBody CategoriaDto dto) { return service.update(id, dto); }
    @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
