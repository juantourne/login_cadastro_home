package com.example.login_cadastro.usuario;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UsuarioResponseDTO> listarTodos() {

        List<UsuarioResponseDTO> usuariosResponse = new ArrayList<>();

        for(Usuario usuario : usuarioRepository.findAll()) {
            usuariosResponse.add(usuarioMapper.toResponse(usuario));
        }

        return usuariosResponse;
    }

    public UsuarioResponseDTO buscarPorId(Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoIdentificadoException("Usuário não encontrado."));

        return usuarioMapper.toResponse(usuario);
    }


    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO usuarioRequest) {

        if (!usuarioRequest.getSenha().equals(usuarioRequest.getConfirmarSenha())) {
            throw new SenhasNaoBatemException("Senha e confirmar senha são diferentes.");
        }

        if (usuarioRepository.existsByUsername(usuarioRequest.getUsername())) {
            throw new UsuarioJaExisteException("Usuário já existe.");
        }
        if (usuarioRepository.existsByEmail(usuarioRequest.getEmail())) {
            throw new EmailJaExisteException("Email já existe.");
        }

        Usuario usuario = usuarioMapper.toEntity(usuarioRequest);
        usuario.setSenha(passwordEncoder.encode(usuarioRequest.getSenha()));

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return usuarioMapper.toResponse(usuarioSalvo);
    }

    public UsuarioResponseDTO atualizarTudo(Long id, UsuarioRequestDTO usuarioRequest) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoIdentificadoException("Usuário não encontrado."));

            usuario.setUsername(usuarioRequest.getUsername());
            usuario.setEmail(usuarioRequest.getEmail());
            usuario.setSenha(passwordEncoder.encode(usuarioRequest.getSenha()));

        return usuarioMapper.toResponse(usuarioRepository.save(usuario));
    }

    public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioUpdateDTO usuarioUpdate) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoIdentificadoException("Usuário não encontrado."));

        if(usuarioUpdate.getUsername() != null) {
            usuario.setUsername(usuarioUpdate.getUsername());
        }
        if(usuarioUpdate.getEmail() != null) {
            usuario.setEmail(usuarioUpdate.getEmail());
        }
        if(usuarioUpdate.getSenha() != null) {
            if(usuarioUpdate.getSenha().equals(usuarioUpdate.getConfirmarSenha())) {
                usuario.setSenha(passwordEncoder.encode(usuarioUpdate.getSenha()));
            } else {
                throw new SenhasNaoBatemException("Senha e confirmar senha diferentes.");
            }
        }

        return usuarioMapper.toResponse(usuarioRepository.save(usuario));
    }

    public void deletarUsuario(Long id) {

        if(!usuarioRepository.existsById(id)) {
            throw new UsuarioNaoIdentificadoException("Usuário não encontrado.");
        }
        usuarioRepository.deleteById(id);
    }
}
