let idiomaAtual = localStorage.getItem("idioma") || "pt";
let traducoesCarregadas = {};

//Variável referente a div que engloba todos os países
const menuPaises = document.getElementById("paises");

/* Função para localizar idioma que usuário deseja (envia o código da tag A que usuário selecionou) */
menuPaises.addEventListener("click", (event) => {
    if (event.target.tagName === "A") {
        event.preventDefault();
        const codigoPais = event.target.dataset.pais;
        alterarLinguagem(codigoPais);
    }
});

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

/* Função que lê JSON e carrega conteúdo do arquivo na variável traducoesCarregadas */
async function carregaIdioma(idioma) {
    try {
        const resposta = await fetch(`i18n/${idioma}.json`);

        if(!resposta.ok) {
            throw new Error (`Idioma não conseguiu ser carregado: ${resposta.status}`);
        }
        traducoesCarregadas = await resposta.json();

    } catch (erro) {
        console.error(erro);
    }
}

/* Função que ao receber a chave da tag HTML, retorna o conteúdo do JSON referente a essa tag (chave) */
function traduzirTextos(chave) {
    return traducoesCarregadas[chave] || chave;
}

/* Função que lista cada tag HTML e atualiza seu conteúdo de acordo com idioma escolhido (ou padrão "pt") */
function aplicaTraducao() {
    document.querySelectorAll("[data-i18n]").forEach(element => {
        element.textContent = traduzirTextos(element.dataset.i18n);
    });

    document.querySelectorAll("[data-i18n-placeholder]").forEach(element => {
        element.placeholder = traduzirTextos(element.dataset.i18nPlaceholder);
    });
}

/* Carrega código para analisar idioma que usuário escolheu e já chama função para carregar arquivo JSON */
async function alterarLinguagem(codigoPais) {
    const listaPaises = {
        US: "en", CA: "en", AU: "en", SG: "en", GB: "en", BR: "pt"
    };

    const idioma = listaPaises[codigoPais] || "pt";
    idiomaAtual = idioma;
    localStorage.setItem("idioma", idioma);
    await carregaIdioma(idioma);
    aplicaTraducao();
}

/* Aplica tradução direto quando a aplicação é carregada */
document.addEventListener("DOMContentLoaded", async () => {
    await carregaIdioma(idiomaAtual);
    aplicaTraducao();
});

export { idiomaAtual, carregaIdioma, traduzirTextos, aplicaTraducao, alterarLinguagem };