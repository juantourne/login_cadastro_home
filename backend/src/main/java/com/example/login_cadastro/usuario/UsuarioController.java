package com.example.login_cadastro.usuario;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarTodos() {
        List<UsuarioResponseDTO> usuariosResponse = usuarioService.listarTodos();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usuariosResponse);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable Long id){
        UsuarioResponseDTO usuarioResponse = usuarioService.buscarPorId(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usuarioResponse);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrar(@Valid @RequestBody UsuarioRequestDTO usuarioRequest) {

        UsuarioResponseDTO usuarioResponse = usuarioService.cadastrar(usuarioRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuarioResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody UsuarioRequestDTO usuarioRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usuarioService.atualizarTudo(id, usuarioRequest));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizarEspecifico(@PathVariable Long id, @Valid @RequestBody UsuarioUpdateDTO usuarioUpdate) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usuarioService.atualizarUsuario(id, usuarioUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {

        usuarioService.deletarUsuario(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(null);
    }
}
