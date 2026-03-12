package com.example.practicanro01.service;
import com.example.practicanro01.dto.CompraDetalleDto;
import com.example.practicanro01.entity.CompraDetalle;
import com.example.practicanro01.repository.CompraDetalleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;import java.util.stream.Collectors;
@Service @Transactional
public class CompraDetalleService {
    private final CompraDetalleRepository repository;
    public CompraDetalleService(CompraDetalleRepository repository) { this.repository = repository; }
    public List<CompraDetalleDto> findAll() { return repository.findAll().stream().map(this::toDto).collect(Collectors.toList()); }
    public CompraDetalleDto findById(Long id) { return toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("CompraDetalle not found"))); }
    public CompraDetalleDto create(CompraDetalleDto dto) { CompraDetalle entity = toEntity(dto); entity.setId(null); return toDto(repository.save(entity)); }
    public CompraDetalleDto update(Long id, CompraDetalleDto dto) { CompraDetalle entity = toEntity(dto); entity.setId(id); return toDto(repository.save(entity)); }
    public void delete(Long id) { repository.deleteById(id); }
    private CompraDetalle toEntity(CompraDetalleDto dto) { CompraDetalle entity = new CompraDetalle(); entity.setCompraId(dto.getCompraId());
    entity.setProductoId(dto.getProductoId());
    entity.setCantidad(dto.getCantidad());
    entity.setPrecioUnitario(dto.getPrecioUnitario());
    entity.setSubtotal(dto.getSubtotal()); return entity; }
    private CompraDetalleDto toDto(CompraDetalle entity) { CompraDetalleDto dto = new CompraDetalleDto(); dto.setId(entity.getId());
    dto.setCompraId(entity.getCompraId());
    dto.setProductoId(entity.getProductoId());
    dto.setCantidad(entity.getCantidad());
    dto.setPrecioUnitario(entity.getPrecioUnitario());
    dto.setSubtotal(entity.getSubtotal()); return dto; }
}
