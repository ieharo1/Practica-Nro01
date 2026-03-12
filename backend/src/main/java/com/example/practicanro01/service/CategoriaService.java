package com.example.practicanro01.service;
import com.example.practicanro01.dto.CategoriaDto;
import com.example.practicanro01.entity.Categoria;
import com.example.practicanro01.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;import java.util.stream.Collectors;
@Service @Transactional
public class CategoriaService {
    private final CategoriaRepository repository;
    public CategoriaService(CategoriaRepository repository) { this.repository = repository; }
    public List<CategoriaDto> findAll() { return repository.findAll().stream().map(this::toDto).collect(Collectors.toList()); }
    public CategoriaDto findById(Long id) { return toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Categoria not found"))); }
    public CategoriaDto create(CategoriaDto dto) { Categoria entity = toEntity(dto); entity.setId(null); return toDto(repository.save(entity)); }
    public CategoriaDto update(Long id, CategoriaDto dto) { Categoria entity = toEntity(dto); entity.setId(id); return toDto(repository.save(entity)); }
    public void delete(Long id) { repository.deleteById(id); }
    private Categoria toEntity(CategoriaDto dto) { Categoria entity = new Categoria(); entity.setNombre(dto.getNombre());
    entity.setDescripcion(dto.getDescripcion()); return entity; }
    private CategoriaDto toDto(Categoria entity) { CategoriaDto dto = new CategoriaDto(); dto.setId(entity.getId());
    dto.setNombre(entity.getNombre());
    dto.setDescripcion(entity.getDescripcion()); return dto; }
}
