package com.example.login_cadastro.mapper;


import com.example.login_cadastro.dto.UsuarioRequestDTO;
import com.example.login_cadastro.dto.UsuarioResponseDTO;
import com.example.login_cadastro.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequestDTO usuarioRequest) {
        Usuario usuario = new Usuario();

        usuario.setNome(usuarioRequest.getNome());
        usuario.setUsername(usuarioRequest.getUsername());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setSenha(usuarioRequest.getSenha());

        return usuario;
    }

    public UsuarioResponseDTO toResponse(Usuario usuario) {
        UsuarioResponseDTO usuarioResponse = new UsuarioResponseDTO();

        usuarioResponse.setNome(usuario.getNome());
        usuarioResponse.setUsername(usuario.getUsername());
        usuarioResponse.setEmail(usuario.getEmail());

        return usuarioResponse;
    }

}
