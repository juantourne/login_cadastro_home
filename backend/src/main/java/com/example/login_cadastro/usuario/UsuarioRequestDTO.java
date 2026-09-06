package com.example.login_cadastro.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioRequestDTO {

    @NotBlank(message = "Campo usuário deve ser preenchido.")
    private String username;

    @NotBlank(message = "Campo email deve ser preenchido.")
    @Email(message = "Digite um email válido.")
    private String email;

    @Size(min=6, message = "A senha deve conter pelo menos 6 caracteres.")
    @NotBlank(message = "Campo senha deve ser preenchido.")
    private String senha;

    @NotBlank(message = "Campo confirmar senha deve ser preenchido.")
    private String confirmarSenha;

    public UsuarioRequestDTO(String username, String email, String senha, String confirmarSenha) {
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.confirmarSenha = confirmarSenha;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getConfirmarSenha() { return confirmarSenha; }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setConfirmarSenha(String confirmarSenha) { this.confirmarSenha = confirmarSenha; }
}
