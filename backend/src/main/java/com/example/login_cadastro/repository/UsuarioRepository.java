package com.example.login_cadastro.repository;

import com.example.login_cadastro.dto.UsuarioRequestDTO;
import com.example.login_cadastro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    Optional<Usuario> findByEmailOrUsername(String email, String username);
}
