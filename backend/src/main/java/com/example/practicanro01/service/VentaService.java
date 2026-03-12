package com.example.practicanro01.service;
import com.example.practicanro01.dto.VentaDto;
import com.example.practicanro01.entity.Venta;
import com.example.practicanro01.repository.VentaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;import java.util.stream.Collectors;
@Service @Transactional
public class VentaService {
    private final VentaRepository repository;
    public VentaService(VentaRepository repository) { this.repository = repository; }
    public List<VentaDto> findAll() { return repository.findAll().stream().map(this::toDto).collect(Collectors.toList()); }
    public VentaDto findById(Long id) { return toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Venta not found"))); }
    public VentaDto create(VentaDto dto) { Venta entity = toEntity(dto); entity.setId(null); return toDto(repository.save(entity)); }
    public VentaDto update(Long id, VentaDto dto) { Venta entity = toEntity(dto); entity.setId(id); return toDto(repository.save(entity)); }
    public void delete(Long id) { repository.deleteById(id); }
    private Venta toEntity(VentaDto dto) { Venta entity = new Venta(); entity.setClienteId(dto.getClienteId());
    entity.setFecha(dto.getFecha());
    entity.setTotal(dto.getTotal());
    entity.setEstado(dto.getEstado()); return entity; }
    private VentaDto toDto(Venta entity) { VentaDto dto = new VentaDto(); dto.setId(entity.getId());
    dto.setClienteId(entity.getClienteId());
    dto.setFecha(entity.getFecha());
    dto.setTotal(entity.getTotal());
    dto.setEstado(entity.getEstado()); return dto; }
}
