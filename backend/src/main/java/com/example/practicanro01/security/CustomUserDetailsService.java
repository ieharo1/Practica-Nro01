package com.example.practicanro01.security;
import com.example.practicanro01.entity.Usuario;import com.example.practicanro01.repository.UsuarioRepository;import org.springframework.security.core.authority.SimpleGrantedAuthority;import org.springframework.security.core.userdetails.*;import org.springframework.stereotype.Service;import java.util.List;
@Service public class CustomUserDetailsService implements UserDetailsService { private final UsuarioRepository repo; public CustomUserDetailsService(UsuarioRepository repo) { this.repo = repo; }
    @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { Usuario u = repo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found")); return new User(u.getUsername(), u.getPassword(), u.getEnabled(), true, true, true, List.of(new SimpleGrantedAuthority("ROLE_" + u.getRole()))); }
}
