package com.example.practicanro01.controller;
import com.example.practicanro01.dto.RolDto;
import com.example.practicanro01.service.RolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/rols")
public class RolController {
    private final RolService service;
    public RolController(RolService service) { this.service = service; }
    @GetMapping public List<RolDto> findAll() { return service.findAll(); }
    @GetMapping("/<built-in function id>") public RolDto findById(@PathVariable Long id) { return service.findById(id); }
    @PostMapping public RolDto create(@RequestBody RolDto dto) { return service.create(dto); }
    @PutMapping("/<built-in function id>") public RolDto update(@PathVariable Long id, @RequestBody RolDto dto) { return service.update(id, dto); }
    @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
