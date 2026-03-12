package com.example.practicanro01.service;
import com.example.practicanro01.dto.RolDto;
import com.example.practicanro01.entity.Rol;
import com.example.practicanro01.repository.RolRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;import java.util.stream.Collectors;
@Service @Transactional
public class RolService {
    private final RolRepository repository;
    public RolService(RolRepository repository) { this.repository = repository; }
    public List<RolDto> findAll() { return repository.findAll().stream().map(this::toDto).collect(Collectors.toList()); }
    public RolDto findById(Long id) { return toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Rol not found"))); }
    public RolDto create(RolDto dto) { Rol entity = toEntity(dto); entity.setId(null); return toDto(repository.save(entity)); }
    public RolDto update(Long id, RolDto dto) { Rol entity = toEntity(dto); entity.setId(id); return toDto(repository.save(entity)); }
    public void delete(Long id) { repository.deleteById(id); }
    private Rol toEntity(RolDto dto) { Rol entity = new Rol(); entity.setName(dto.getName());
    entity.setDescription(dto.getDescription()); return entity; }
    private RolDto toDto(Rol entity) { RolDto dto = new RolDto(); dto.setId(entity.getId());
    dto.setName(entity.getName());
    dto.setDescription(entity.getDescription()); return dto; }
}
