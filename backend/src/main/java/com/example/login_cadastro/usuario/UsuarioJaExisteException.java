package com.example.login_cadastro.usuario;

public class UsuarioJaExisteException extends RuntimeException{
    public UsuarioJaExisteException(String message) {
        super(message);
    }
}
