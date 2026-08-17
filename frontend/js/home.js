//Variáveis para checar login do usuário
const dadosUsuario = sessionStorage.getItem("usuarioLogado");
const usuarioLogado = JSON.parse(dadosUsuario);

//Variável de opções do menu hambúrguer
const navList = document.getElementById("list");

//Variáveis relacionadas ao menu de línguas
const btnLanguage = document.getElementById("btn-language");
const modalLanguage = document.getElementById("modal-language");
const fecharLanguage = document.getElementById("fechar-language");

//Variáveis relacionadas ao menu do usuário
const infoUser = document.getElementById("user-info");
const modalUser = document.getElementById("modal-user"); 
const fecharUser = document.getElementById("fechar-user");
//Textos da tela de usuário
const userName = document.getElementById("name");
const userEmail = document.getElementById("email");
const userPassword = document.getElementById("password");

//Botão fechar home
const fecharHome = document.getElementById("fechar-home");

//Fecha home.html se usuário não tiver logado
if (!usuarioLogado) {
    window.location.replace("index.html");
}

/* Funções para abrir e fechar tela de linguagens */
btnLanguage.addEventListener("click", () => {
    modalLanguage.classList.add("ativo");
});

fecharLanguage.addEventListener("click", () => {
    modalLanguage.classList.remove("ativo");
});

modalLanguage.addEventListener("click", (event) => {
    if(event.target === modalLanguage) {
        modalLanguage.classList.remove("ativo");
    }
});

document.addEventListener("keydown", event => {
    if(event.key === "Escape") {
        modalLanguage.classList.remove("ativo");
    }
});

/* Funções para abrir e fechar tela de usuário */
infoUser.addEventListener("click", () => {
    modalUser.classList.add("ativo");
});

fecharUser.addEventListener("click", () => {
    modalUser.classList.remove("ativo");
});

modalUser.addEventListener("click", (event) => {
    if(event.target === modalUser) {
        modalUser.classList.remove("ativo");
    }
});

document.addEventListener("keydown", (event) => {
    if(event.key === "Escape") {
        modalUser.classList.remove("ativo");
    }
});

/* Preenche dados do usuário na tela do usuário */
userName.textContent = usuarioLogado.username;
userEmail.textContent = usuarioLogado.email;
userPassword.textContent = usuarioLogado.password;

/* Função para fechar tela home */
fecharHome.addEventListener("click", () => {
    sessionStorage.removeItem("usuarioLogado");

    window.location.replace("index.html");
});

/* Abre e fecha menu hambúrguer */
function alterarMenu() {
    if(navList.style.display === 'none') {
        navList.style.display = 'flex';
    } else {
        navList.style.display = 'none';
    }
}


