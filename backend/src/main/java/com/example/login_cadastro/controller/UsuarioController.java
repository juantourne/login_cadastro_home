package com.example.login_cadastro.controller;

import com.example.login_cadastro.dto.UsuarioRequestDTO;
import com.example.login_cadastro.dto.UsuarioResponseDTO;
import com.example.login_cadastro.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public UsuarioResponseDTO cadastrar(@Valid @RequestBody UsuarioRequestDTO usuario) {
        return usuarioService.cadastrar(usuario);
    }
}
