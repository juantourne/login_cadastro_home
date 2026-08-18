import { idiomaAtual, carregaIdioma, traduzirTextos, aplicaTraducao, alterarLinguagem } from "./i18n.js";

const loginForm = document.getElementById("login-form");

loginForm.addEventListener("submit", fazerLogin);

/* Função referente ao login - com validação e armazenamento do login */
function fazerLogin(event) {
    //Campos que usuário preenche
    const user = document.getElementById("username");
    const password = document.getElementById("current-password");

    //Campos de validação
    const validacaoUser = document.getElementById("validacao-user");
    const validacaoPassword = document.getElementById("validacao-password");

    //Variável que valida login
    let valido = true;

    event.preventDefault();
    
    if(!user.value) {
        validacaoUser.textContent = traduzirTextos("erroUsuarioVazio");
        valido = false;
    } else {
        validacaoUser.textContent = "";
    }
    
    if (!password.value) {
        validacaoPassword.textContent = traduzirTextos("erroSenhaVazia");
        valido = false;
    } else {
        validacaoPassword.textContent = "";
    }

    if (valido) {
        const usuarios = JSON.parse(localStorage.getItem("usuarios")) || [];
        const usuarioEncontrado = usuarios.find(u => (u.username === user.value || u.email === user.value) && u.password === password.value);

        if (!usuarioEncontrado) {
            validacaoUser.textContent = traduzirTextos("erroUsuarioSenha");
            valido = false;
        } 

        if (valido) {
            sessionStorage.setItem("usuarioLogado", JSON.stringify(usuarioEncontrado));

            loginForm.reset();

            window.location.href = "home.html";
        }
    }
}


