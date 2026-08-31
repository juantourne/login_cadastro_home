<h1 align="center">
  Login e Cadastro
</h1>


# Sobre o projeto
<p align="justify">
  O projeto que estou desenvolvendo tem como objetivo me ajudar a desenvolver habilidades essenciais para um desenvolvedor... tais como frontend básico e funcional, além de um backend consistente, com autenticação, banco de dados e tokens para maior segurança. 
</p>
<p align="justify">
  As ferramentas que utilizei (ou que ainda vou utilizar) estão listados no tópico Tecnologias. O projeto consiste de três telas, a de <strong>Cadastro</strong>, a de <strong>Login</strong> e a <strong>Home</strong>. A de cadastro apresenta um formulário mais extenso que guarda dados secundários, além de guardar os dados que o usuário utilizará no login (usuário ou email e senha), a tela home, por sua vez, é uma tela que desenvolvi bem básica, mas que corresponde a uma aba que o usuário entraria ao efetuar login. 
</p>

## Aprendizado
<p align="justify">
  Comecei fortalecendo meus conhecimentos produzindo o corpo das janelas Cadastro, Login e Home. A partir delas, consegui relembrar funcionalidades como responsividade, tags com classes, ids e estilização.
</p>
<p align="justify">
  Mais a frente, comecei a aplicar o JavaScript para conseguir trazer funcionalidades ao projeto, adicionei validações dos inputs de dados que eram recebidos na tela de cadastro e login. Depois disso, estudei sobre localStorage e sessionStorage (que seriam a primeira forma que eu usaria para armazenar os dados do usuário para no login conseguir acessar a tela Home do projeto) e, apesar de essas ferramentas não serem apropriadas para armazenar dados sensíveis como a senha de um usuário, acabei usando-as mais a fim de aprendizado e para conseguir acessar a tela Home.
</p>
<p align="justify">
  Outras funcionalidades que aprendi depois no JavaScript foram interações HTML/CSS com o próprio JS... ao invés de usar 'alerts' para dar avisos ao usuário, implementei tags 'p' que apareceriam com mensagens de aviso no lugar. Outra coisa que utilizei foram as funções de 'click', 'keydown', 'DOMContentLoaded' para lidar com botões, modals e a tradução do site (que até o momento só tem em inglês e português). Estou aprendendo operações assíncronas no momento (que já utilizei um pouco para traduzir o site) e busco desenvolver um backend para esse projeto.
</p>
<p align="justify">
  No momento, estou estudando Java (Spring Boot) e Docker. Agora sim estou deixando a minha aplicação mais completa, já estou estudando conceitos importantes como Repository/Service/Controller, DTO's, Mappers (MapStruct não utilizarei a fins de aprendizado). Além desses conceitos, tinha visto também a parte de configuração de arquivos essenciais para que o backend de fato funcione, como 'application.properties', '.env', o próprio 'docker-compose.yml'... estou me sentindo realmente um desenvolvedor agora que estou chegando nessa parte mais técnica. 
</p>

## Funcionalidades
### Cadastro
- [x] Página de cadastro
- [x] Cadastro de usuário
- [x] Cadastro de e-mail
- [x] Cadastro de senha
- [x] Validação de campos obrigatórios
- [x] Validação de username duplicado
- [x] Validação de e-mail duplicado
- [x] Armazenamento dos usuários
- [x] Mensagens de erro para dados inválidos

### Login
- [x] Página de login
- [x] Login utilizando e-mail
- [x] Validação de e-mail
- [x] Validação de senha
- [x] Verificação das credenciais cadastradas
- [x] Mensagem de erro para credenciais inválidas
- [x] Redirecionamento para a Home após o login
- [x] Controle de usuário logado

### Home
- [x] Página inicial após o login
- [x] Navbar
- [x] Menu responsivo
- [x] Sistema de logout
- [x] Menu de idiomas
- [x] Seleção de país/idioma
- [x] Menu de informações do usuário
- [x] Exibição das informações do usuário
- [x] Proteção da página para usuários não autenticados

### Informações do usuário
- [x] Tela de informações do usuário
- [x] Exibição do nome
- [x] Exibição do e-mail
- [x] Exibição da senha

### Interface
- [x] Layout responsivo
- [x] Estilização com CSS
- [x] Modais
- [x] Ícones de navegação
- [x] Menu mobile
- [x] Organização por páginas

### JavaScript
- [x] Manipulação do DOM
- [x] Validação de formulários
- [x] Eventos de clique
- [x] Controle de modais
- [x] Controle de sessão
- [x] Armazenamento de dados com LocalStorage
- [x] Armazenamento da sessão com SessionStorage
- [x] Redirecionamento entre páginas

### Em desenvolvimento
- [ ] Recuperação de senha
- [ ] Alteração de senha
- [ ] Edição das informações do usuário
- [ ] Backend
- [ ] Banco de dados
- [ ] Autenticação com servidor

## Tecnologias
  ![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
  ![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)
  ![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)
  ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
  ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
  ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
  ![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
  ![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
