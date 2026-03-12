package com.example.practicanro01.service;
import com.example.practicanro01.dto.InventarioMovimientoDto;
import com.example.practicanro01.entity.InventarioMovimiento;
import com.example.practicanro01.repository.InventarioMovimientoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;import java.util.stream.Collectors;
@Service @Transactional
public class InventarioMovimientoService {
    private final InventarioMovimientoRepository repository;
    public InventarioMovimientoService(InventarioMovimientoRepository repository) { this.repository = repository; }
    public List<InventarioMovimientoDto> findAll() { return repository.findAll().stream().map(this::toDto).collect(Collectors.toList()); }
    public InventarioMovimientoDto findById(Long id) { return toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("InventarioMovimiento not found"))); }
    public InventarioMovimientoDto create(InventarioMovimientoDto dto) { InventarioMovimiento entity = toEntity(dto); entity.setId(null); return toDto(repository.save(entity)); }
    public InventarioMovimientoDto update(Long id, InventarioMovimientoDto dto) { InventarioMovimiento entity = toEntity(dto); entity.setId(id); return toDto(repository.save(entity)); }
    public void delete(Long id) { repository.deleteById(id); }
    private InventarioMovimiento toEntity(InventarioMovimientoDto dto) { InventarioMovimiento entity = new InventarioMovimiento(); entity.setProductoId(dto.getProductoId());
    entity.setTipo(dto.getTipo());
    entity.setCantidad(dto.getCantidad());
    entity.setFecha(dto.getFecha());
    entity.setMotivo(dto.getMotivo()); return entity; }
    private InventarioMovimientoDto toDto(InventarioMovimiento entity) { InventarioMovimientoDto dto = new InventarioMovimientoDto(); dto.setId(entity.getId());
    dto.setProductoId(entity.getProductoId());
    dto.setTipo(entity.getTipo());
    dto.setCantidad(entity.getCantidad());
    dto.setFecha(entity.getFecha());
    dto.setMotivo(entity.getMotivo()); return dto; }
}
