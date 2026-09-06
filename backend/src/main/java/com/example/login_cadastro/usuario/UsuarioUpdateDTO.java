package com.example.login_cadastro.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UsuarioUpdateDTO {

    private String username;

    @Email(message = "Digite um email válido.")
    private String email;

    @Size(min=6, message = "A senha deve conter pelo menos 6 caracteres.")
    private String senha;

    private String confirmarSenha;

    public UsuarioUpdateDTO(String username, String email, String senha, String confirmarSenha) {
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.confirmarSenha = confirmarSenha;
    }

    //Username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Senha
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    //Confirmar senha
    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

}
