# Nubank Registration Automation

Este projeto contém testes automatizados para o processo de registro no Nubank utilizando o padrão de design Page Objects.

## Descrição

O projeto de automação visa testar a funcionalidade de registro de conta e login no site do Nubank. Utilizamos o Selenium WebDriver para interagir com a interface web e o JUnit para estruturar e executar os testes. O padrão Page Objects foi adotado para manter o código de teste organizado e fácil de manter.

## Estrutura do Projeto

O projeto está organizado nas seguintes classes:

- **NubankRegistrationPage**: Contém métodos para interagir com a página de registro do Nubank.
- **NubankLoginPage**: Contém métodos para interagir com a página de login do Nubank.
- **AccountRegistrationTest**: Contém testes para validar o processo de registro de conta.
- **NubankLoginTest**: Contém testes para validar o processo de login.

## Ferramentas e Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para desenvolver os testes.
- **Selenium WebDriver**: Ferramenta de automação de navegadores para interagir com a aplicação web.
- **JUnit**: Framework para criação e execução dos testes unitários.
- **Eclipse**: IDE utilizada para desenvolvimento do projeto.
- **Git**: Sistema de controle de versão para gerenciar o código-fonte.
- **GitHub**: Plataforma para hospedagem do repositório Git.

## Pré-requisitos

- **Java Development Kit (JDK)** instalado.
- **Eclipse IDE** com o plugin **Eclipse EGit** para integração com o Git.
- **Selenium WebDriver** configurado no Eclipse.
- **Driver do navegador** (geckodriver para Firefox) baixado e configurado.

## Configuração do Ambiente

1. **Clone o Repositório**

   ```bash
   git clone https://github.com/seu-usuario/nubank-registration-automation.git


# Cenários de Teste

### Cenários de Teste para Registro de Conta

1. **Cenário: Validação de Conta com CPF Válido**
   - **Dado** que o usuário está na página de registro do Nubank
   - **Quando** o usuário insere um CPF válido
   - **E** clica no botão de continuar
   - **Então** a página de registro exibe o título "Complete os campos ao lado para pedir sua Conta e Cartão de crédito"
   - **E** o usuário pode preencher os campos de nome, telefone, email e confirmação de email
   - **E** aceita os termos e condições
   - **E** clica no botão para continuar o cadastro

2. **Cenário: Validação de CPF Inválido**
   - **Dado** que o usuário está na página de registro do Nubank
   - **Quando** o usuário insere um CPF inválido (ex. "00000000000")
   - **E** clica no botão de continuar
   - **Então** uma mensagem de erro "Precisamos de um CPF válido." é exibida

3. **Cenário: Validação de Email de Confirmação Inválido**
   - **Dado** que o usuário está na página de registro do Nubank
   - **Quando** o usuário insere um CPF válido
   - **E** clica no botão de continuar
   - **E** preenche os campos de nome, telefone, email e um email de confirmação que não corresponde ao email original
   - **E** aceita os termos e condições
   - **E** clica no botão para continuar o cadastro
   - **Então** uma mensagem de erro "Ops. Está diferente do campo anterior." é exibida

