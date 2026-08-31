package com.example.login_cadastro.service;

import com.example.login_cadastro.dto.UsuarioRequestDTO;
import com.example.login_cadastro.dto.UsuarioResponseDTO;
import com.example.login_cadastro.mapper.UsuarioMapper;
import com.example.login_cadastro.model.Usuario;
import com.example.login_cadastro.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO usuarioRequest) {
        if (usuarioRepository.existsByUsername(usuarioRequest.getUsername())) {
            throw new RuntimeException("Usuário já existe.");
        }
        if (usuarioRepository.existsByEmail(usuarioRequest.getEmail())) {
            throw new RuntimeException("Email já existe.");
        }

        Usuario usuario = usuarioMapper.toEntity(usuarioRequest);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return usuarioMapper.toResponse(usuarioSalvo);
    }
}
