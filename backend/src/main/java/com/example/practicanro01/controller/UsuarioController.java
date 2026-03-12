package com.example.practicanro01.controller;
import com.example.practicanro01.dto.UsuarioDto;
import com.example.practicanro01.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService service;
    public UsuarioController(UsuarioService service) { this.service = service; }
    @GetMapping public List<UsuarioDto> findAll() { return service.findAll(); }
    @GetMapping("/<built-in function id>") public UsuarioDto findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping public UsuarioDto create(@RequestBody UsuarioDto dto) { return service.create(dto); }
    @PutMapping("/<built-in function id>") public UsuarioDto update(@PathVariable Long id, @RequestBody UsuarioDto dto) { return service.update(id, dto); }
    @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
