package com.example.login_cadastro.exception;

public class ErrorResponseDTO {

    private String campo;
    private String message;

    public ErrorResponseDTO() {

    }
    public ErrorResponseDTO(String campo, String message) {
        this.campo = campo;
        this.message = message;
    }

    public String getCampo() {
        return campo;
    }

    public String getMessage() {
        return message;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
