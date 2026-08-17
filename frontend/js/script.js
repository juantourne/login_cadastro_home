const loginForm = document.getElementById("login-form");
const cadastroForm = document.getElementById("cadastro-form");

/* Caso login */
if(loginForm) {
    loginForm.addEventListener("submit", fazerLogin);
}

/* Caso cadastro */
if(cadastroForm) {
    cadastroForm.addEventListener("submit", fazerCadastro);
}

/* Função referente ao login */
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
        validacaoPassword.textContent = traduzirTextos("erroSenhaVazio");
        valido = false;
    } else {
        validacaoPassword.textContent = "";
    }

    if (valido) {
        const usuarios = JSON.parse(localStorage.getItem("usuarios")) || [];
        const usuarioEncontrado = usuarios.find(u => u.username === user.value || u.email === user.value && u.password === password.value);

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


/* Função referente ao cadastro */
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

//Variáveis referentes ao botão linguagem e ao modal linguagem
const botaoLinguagem = document.getElementById("btn-language");
const modalLanguage = document.getElementById("modal-language");
const botaoFecharLinguagem = document.getElementById("fechar-language");

/* Função para abrir modal linguagem */
botaoLinguagem.addEventListener("click", () =>{
    modalLanguage.classList.add("ativo");
});

botaoFecharLinguagem.addEventListener("click", () => {
    modalLanguage.classList.remove("ativo");
});

modalLanguage.addEventListener("click", event => {
    if(event.target === modalLanguage){
        modalLanguage.classList.remove("ativo");
    }
});

document.addEventListener("keydown", event => {
    if(event.key === "Escape") {
        modalLanguage.classList.remove("ativo");
    }
});
