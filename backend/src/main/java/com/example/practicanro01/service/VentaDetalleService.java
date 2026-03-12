package com.example.practicanro01.service;
import com.example.practicanro01.dto.VentaDetalleDto;
import com.example.practicanro01.entity.VentaDetalle;
import com.example.practicanro01.repository.VentaDetalleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;import java.util.stream.Collectors;
@Service @Transactional
public class VentaDetalleService {
    private final VentaDetalleRepository repository;
    public VentaDetalleService(VentaDetalleRepository repository) { this.repository = repository; }
    public List<VentaDetalleDto> findAll() { return repository.findAll().stream().map(this::toDto).collect(Collectors.toList()); }
    public VentaDetalleDto findById(Long id) { return toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("VentaDetalle not found"))); }
    public VentaDetalleDto create(VentaDetalleDto dto) { VentaDetalle entity = toEntity(dto); entity.setId(null); return toDto(repository.save(entity)); }
    public VentaDetalleDto update(Long id, VentaDetalleDto dto) { VentaDetalle entity = toEntity(dto); entity.setId(id); return toDto(repository.save(entity)); }
    public void delete(Long id) { repository.deleteById(id); }
    private VentaDetalle toEntity(VentaDetalleDto dto) { VentaDetalle entity = new VentaDetalle(); entity.setVentaId(dto.getVentaId());
    entity.setProductoId(dto.getProductoId());
    entity.setCantidad(dto.getCantidad());
    entity.setPrecioUnitario(dto.getPrecioUnitario());
    entity.setSubtotal(dto.getSubtotal()); return entity; }
    private VentaDetalleDto toDto(VentaDetalle entity) { VentaDetalleDto dto = new VentaDetalleDto(); dto.setId(entity.getId());
    dto.setVentaId(entity.getVentaId());
    dto.setProductoId(entity.getProductoId());
    dto.setCantidad(entity.getCantidad());
    dto.setPrecioUnitario(entity.getPrecioUnitario());
    dto.setSubtotal(entity.getSubtotal()); return dto; }
}
