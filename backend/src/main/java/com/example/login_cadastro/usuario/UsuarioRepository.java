package com.example.login_cadastro.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByEmailOrUsername(String email, String username);
}
