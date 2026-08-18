import { idiomaAtual, carregaIdioma, traduzirTextos, aplicaTraducao, alterarLinguagem } from "./i18n.js";

const cadastroForm = document.getElementById("cadastro-form");

cadastroForm.addEventListener("submit", fazerCadastro);

/* Função referente ao cadastro - com validação e armazenamento do cadastro */
function fazerCadastro(event) {
    //Variáveis que usuário digitou
    const user = document.getElementById("username");
    const password = document.getElementById("current-password");
    const confirmPassword = document.getElementById("confirm-password");
    const email = document.getElementById("email");

    //Campos de validação
    const validacaoUser = document.getElementById("validacao-user");
    const validacaoEmail = document.getElementById("validacao-email");
    const validacaoPassword = document.getElementById("validacao-password");
    const validacaoConfirmPassword = document.getElementById("validacao-confirm-password");

    //Valida cadastro
    let valido = true;

    //Variável que armazena dados de usuário
    const usuarios = JSON.parse(localStorage.getItem("usuarios")) || [];

    event.preventDefault();

    if (!user.value) {
        validacaoUser.textContent = traduzirTextos("erroUsuarioVazio");
        valido = false;
    } else if (usuarios.some(u => user.value == u.username)) {
        validacaoUser.textContent = traduzirTextos("erroUsuarioCadastrado");
        valido = false;
    } else {
        validacaoUser.textContent = "";
    }

    if (!email.value) {
        validacaoEmail.textContent = traduzirTextos("erroEmailVazio");
        valido = false;
    } else if (usuarios.some(u => email.value == u.email)) {
        validacaoEmail.textContent = traduzirTextos("erroEmailCadastrado");
        valido = false;
    } else {
        validacaoEmail.textContent = "";
    }

    if (!password.value) {
        validacaoPassword.textContent = traduzirTextos("erroSenhaVazia");
        valido = false;
    } else if(password.value.length < 6) {
        validacaoPassword.textContent = traduzirTextos("erroSenhaCurta");
        valido = false;
    } else {
        validacaoPassword.textContent = "";
    }
    
    if (!confirmPassword.value) {
        validacaoConfirmPassword.textContent = traduzirTextos("erroConfirmeSenhaVazia");
        valido = false;
    } else if(password.value !== confirmPassword.value){
        validacaoConfirmPassword.textContent = traduzirTextos("erroSenhaNaoCondiz");
        valido = false;
    } else {
        validacaoConfirmPassword.textContent = "";
    }

    if(valido) {
        const userCadastro = {
            username: user.value,
            email: email.value,
            password: password.value
        };
    
       usuarios.push(userCadastro);
       localStorage.setItem("usuarios", JSON.stringify(usuarios));

        cadastroForm.reset();

        window.location.href = "index.html";
    }
}   