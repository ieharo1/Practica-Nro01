package com.example.practicanro01.service;
import com.example.practicanro01.dto.UsuarioDto;
import com.example.practicanro01.entity.Usuario;
import com.example.practicanro01.repository.UsuarioRepository;
import com.example.practicanro01.security.RegisterRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;import java.util.stream.Collectors;
@Service @Transactional
public class UsuarioService {
    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    public UsuarioService(UsuarioRepository repository, PasswordEncoder passwordEncoder) { this.repository = repository; this.passwordEncoder = passwordEncoder; }
    public List<UsuarioDto> findAll() { return repository.findAll().stream().map(this::toDto).collect(Collectors.toList()); }
    public UsuarioDto findById(Long id) { return toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Usuario not found"))); }
    public UsuarioDto create(UsuarioDto dto) { Usuario entity = toEntity(dto); entity.setId(null); if (entity.getPassword() != null) { entity.setPassword(passwordEncoder.encode(entity.getPassword())); } return toDto(repository.save(entity)); }
    public UsuarioDto update(Long id, UsuarioDto dto) { Usuario entity = toEntity(dto); entity.setId(id); if (entity.getPassword() != null && !entity.getPassword().isBlank()) { entity.setPassword(passwordEncoder.encode(entity.getPassword())); } return toDto(repository.save(entity)); }
    public void delete(Long id) { repository.deleteById(id); }
    public void register(RegisterRequest request) { Usuario u = new Usuario(); u.setUsername(request.getUsername()); u.setPassword(passwordEncoder.encode(request.getPassword())); u.setRole(request.getRole() == null ? "USER" : request.getRole()); u.setEnabled(true); repository.save(u); }
    private Usuario toEntity(UsuarioDto dto) { Usuario u = new Usuario(); u.setId(dto.getId()); u.setUsername(dto.getUsername()); u.setPassword(dto.getPassword()); u.setRole(dto.getRole()); u.setEnabled(dto.getEnabled()); return u; }
    private UsuarioDto toDto(Usuario u) { UsuarioDto dto = new UsuarioDto(); dto.setId(u.getId()); dto.setUsername(u.getUsername()); dto.setPassword(u.getPassword()); dto.setRole(u.getRole()); dto.setEnabled(u.getEnabled()); return dto; }
}
