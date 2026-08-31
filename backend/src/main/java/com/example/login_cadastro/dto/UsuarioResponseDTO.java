package com.example.login_cadastro.dto;

public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String username;
    private String email;

    public UsuarioResponseDTO(String nome, String username, String email) {
        this.nome = nome;
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
