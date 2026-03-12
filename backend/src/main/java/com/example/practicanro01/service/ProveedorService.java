package com.example.practicanro01.service;
import com.example.practicanro01.dto.ProveedorDto;
import com.example.practicanro01.entity.Proveedor;
import com.example.practicanro01.repository.ProveedorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;import java.util.stream.Collectors;
@Service @Transactional
public class ProveedorService {
    private final ProveedorRepository repository;
    public ProveedorService(ProveedorRepository repository) { this.repository = repository; }
    public List<ProveedorDto> findAll() { return repository.findAll().stream().map(this::toDto).collect(Collectors.toList()); }
    public ProveedorDto findById(Long id) { return toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Proveedor not found"))); }
    public ProveedorDto create(ProveedorDto dto) { Proveedor entity = toEntity(dto); entity.setId(null); return toDto(repository.save(entity)); }
    public ProveedorDto update(Long id, ProveedorDto dto) { Proveedor entity = toEntity(dto); entity.setId(id); return toDto(repository.save(entity)); }
    public void delete(Long id) { repository.deleteById(id); }
    private Proveedor toEntity(ProveedorDto dto) { Proveedor entity = new Proveedor(); entity.setNombre(dto.getNombre());
    entity.setTelefono(dto.getTelefono());
    entity.setEmail(dto.getEmail());
    entity.setDireccion(dto.getDireccion()); return entity; }
    private ProveedorDto toDto(Proveedor entity) { ProveedorDto dto = new ProveedorDto(); dto.setId(entity.getId());
    dto.setNombre(entity.getNombre());
    dto.setTelefono(entity.getTelefono());
    dto.setEmail(entity.getEmail());
    dto.setDireccion(entity.getDireccion()); return dto; }
}
