package com.example.login_cadastro.usuario;


import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequestDTO usuarioRequest) {
        Usuario usuario = new Usuario();

        usuario.setUsername(usuarioRequest.getUsername());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setSenha(usuarioRequest.getSenha());

        return usuario;
    }

    public UsuarioResponseDTO toResponse(Usuario usuario) {
        UsuarioResponseDTO usuarioResponse = new UsuarioResponseDTO();

        usuarioResponse.setId(usuario.getId());
        usuarioResponse.setUsername(usuario.getUsername());
        usuarioResponse.setEmail(usuario.getEmail());

        return usuarioResponse;
    }

}
