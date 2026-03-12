package com.example.practicanro01.service;
import com.example.practicanro01.dto.ProductoDto;
import com.example.practicanro01.entity.Producto;
import com.example.practicanro01.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;import java.util.stream.Collectors;
@Service @Transactional
public class ProductoService {
    private final ProductoRepository repository;
    public ProductoService(ProductoRepository repository) { this.repository = repository; }
    public List<ProductoDto> findAll() { return repository.findAll().stream().map(this::toDto).collect(Collectors.toList()); }
    public ProductoDto findById(Long id) { return toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Producto not found"))); }
    public ProductoDto create(ProductoDto dto) { Producto entity = toEntity(dto); entity.setId(null); return toDto(repository.save(entity)); }
    public ProductoDto update(Long id, ProductoDto dto) { Producto entity = toEntity(dto); entity.setId(id); return toDto(repository.save(entity)); }
    public void delete(Long id) { repository.deleteById(id); }
    private Producto toEntity(ProductoDto dto) { Producto entity = new Producto(); entity.setNombre(dto.getNombre());
    entity.setDescripcion(dto.getDescripcion());
    entity.setPrecio(dto.getPrecio());
    entity.setStock(dto.getStock());
    entity.setCategoriaId(dto.getCategoriaId());
    entity.setProveedorId(dto.getProveedorId());
    entity.setSku(dto.getSku());
    entity.setImeiSerial(dto.getImeiSerial()); return entity; }
    private ProductoDto toDto(Producto entity) { ProductoDto dto = new ProductoDto(); dto.setId(entity.getId());
    dto.setNombre(entity.getNombre());
    dto.setDescripcion(entity.getDescripcion());
    dto.setPrecio(entity.getPrecio());
    dto.setStock(entity.getStock());
    dto.setCategoriaId(entity.getCategoriaId());
    dto.setProveedorId(entity.getProveedorId());
    dto.setSku(entity.getSku());
    dto.setImeiSerial(entity.getImeiSerial()); return dto; }
}
