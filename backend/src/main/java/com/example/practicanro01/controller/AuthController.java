package com.example.practicanro01.controller;
import com.example.practicanro01.security.*;import com.example.practicanro01.service.UsuarioService;
import org.springframework.http.ResponseEntity;import org.springframework.security.authentication.*;import org.springframework.security.core.Authentication;import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager; private final JwtUtil jwtUtil; private final UsuarioService usuarioService;
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UsuarioService usuarioService) { this.authenticationManager = authenticationManager; this.jwtUtil = jwtUtil; this.usuarioService = usuarioService; }
    @PostMapping("/login") public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) { Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())); return ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(auth.getName()))); }
    @PostMapping("/register") public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) { usuarioService.register(request); return ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(request.getUsername()))); }
}
