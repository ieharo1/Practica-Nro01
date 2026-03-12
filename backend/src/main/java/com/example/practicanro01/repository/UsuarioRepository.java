package com.example.practicanro01.repository;
import com.example.practicanro01.entity.Usuario;import org.springframework.data.jpa.repository.JpaRepository;import java.util.Optional;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { Optional<Usuario> findByUsername(String username); }
