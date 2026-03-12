package com.example.practicanro01.service;
import com.example.practicanro01.dto.CompraDto;
import com.example.practicanro01.entity.Compra;
import com.example.practicanro01.repository.CompraRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;import java.util.stream.Collectors;
@Service @Transactional
public class CompraService {
    private final CompraRepository repository;
    public CompraService(CompraRepository repository) { this.repository = repository; }
    public List<CompraDto> findAll() { return repository.findAll().stream().map(this::toDto).collect(Collectors.toList()); }
    public CompraDto findById(Long id) { return toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Compra not found"))); }
    public CompraDto create(CompraDto dto) { Compra entity = toEntity(dto); entity.setId(null); return toDto(repository.save(entity)); }
    public CompraDto update(Long id, CompraDto dto) { Compra entity = toEntity(dto); entity.setId(id); return toDto(repository.save(entity)); }
    public void delete(Long id) { repository.deleteById(id); }
    private Compra toEntity(CompraDto dto) { Compra entity = new Compra(); entity.setProveedorId(dto.getProveedorId());
    entity.setFecha(dto.getFecha());
    entity.setTotal(dto.getTotal());
    entity.setEstado(dto.getEstado()); return entity; }
    private CompraDto toDto(Compra entity) { CompraDto dto = new CompraDto(); dto.setId(entity.getId());
    dto.setProveedorId(entity.getProveedorId());
    dto.setFecha(entity.getFecha());
    dto.setTotal(entity.getTotal());
    dto.setEstado(entity.getEstado()); return dto; }
}
