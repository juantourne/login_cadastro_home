package com.example.login_cadastro.exception;

import com.example.login_cadastro.usuario.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsuarioJaExisteException.class)
    public ResponseEntity<?> handleUsuarioJaExiste(UsuarioJaExisteException excecao) {
        String excecaoMensagem = excecao.getMessage();

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(excecaoMensagem);
    }

    @ExceptionHandler(EmailJaExisteException.class)
    public ResponseEntity<?> handleEmailJaExiste(EmailJaExisteException excecao) {
        String excecaoMensagem = excecao.getMessage();

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(excecaoMensagem);
    }

    @ExceptionHandler(SenhasNaoBatemException.class)
    public ResponseEntity<?> handleSenhasNaoBatem(SenhasNaoBatemException excecao) {
        String excecaoMensagem = excecao.getMessage();

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(excecaoMensagem);
    }

    @ExceptionHandler(UsuarioNaoIdentificadoException.class)
    public ResponseEntity<?> handleUsuarioNaoIdentificado(UsuarioNaoIdentificadoException excecao) {
        String excecaoMensagem = excecao.getMessage();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(excecaoMensagem);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleNotValid(MethodArgumentNotValidException excecao) {

        ArrayList<ErrorResponseDTO> erroResponse = new ArrayList<>();
        String campo;
        String mensagem;

        for (FieldError erro : excecao.getBindingResult().getFieldErrors()) {
            campo = erro.getField();
            mensagem = erro.getDefaultMessage();
            ErrorResponseDTO erroResponseDTO = new ErrorResponseDTO(campo, mensagem);

            erroResponse.add(erroResponseDTO);
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(erroResponse);
    }
}
