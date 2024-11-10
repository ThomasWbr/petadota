# PetAdota - Aplicação Web para Adoção de Animais Abandonados

## Descrição

O **PetAdota** é uma aplicação web desenvolvida para ajudar no processo de adoção de animais abandonados. Através dessa plataforma, abrigos e interessados em adotar pets podem se conectar de forma rápida e eficiente. A aplicação permite o gerenciamento completo dos animais disponíveis para adoção, oferecendo funcionalidades para cadastrar, listar, atualizar e excluir animais.

## Funcionalidades

- **Cadastro de Animais:** Permite que abrigos cadastrem novos animais disponíveis para adoção com informações como nome, tipo, idade, raça, status de adoção, imagem e descrição.
- **Listagem de Animais:** Exibe todos os animais disponíveis para adoção, com possibilidade de filtro por status.
- **Busca por ID:** Permite a busca de um animal específico pelo seu ID, retornando suas informações detalhadas.
- **Atualização de Dados:** Permite que os abrigos atualizem informações sobre os animais, como status de adoção.
- **Exclusão de Animais:** Permite a remoção de registros de animais adotados ou não mais disponíveis.
  
## Tecnologias Usadas

- **Backend:** Spring Boot
- **Banco de Dados:** H2 (em memória)
- **Persistência:** JPA (Jakarta Persistence API)
- **Validação e Exceções:** Validação de dados de entrada e tratamento de exceções personalizadas.
  
## Pré-requisitos

Antes de rodar o projeto, é necessário ter as seguintes ferramentas instaladas:

- Java 17 ou superior
- Maven
- IntelliJ IDEA ou outra IDE de sua preferência

## Como Executar

1. Clone o repositório para sua máquina local:

    ```bash
    git clone https://github.com/ThomasWbr/petadota.git
    ```

2. Abra o projeto na sua IDE.
3. Execute a aplicação como uma aplicação Spring Boot. Na IDE, basta rodar a classe `PetAdotaApplication` (a classe principal com o método `main`).
4. A aplicação estará rodando localmente no endereço [http://localhost:8080](http://localhost:8080).

## Endpoints

- **POST /api/animals** – Criar um novo animal.
- **GET /api/animals** – Listar todos os animais.
- **GET /api/animals/{id}** – Buscar um animal pelo ID.
- **PUT /api/animals/{id}** – Atualizar as informações de um animal.
- **DELETE /api/animals/{id}** – Deletar um animal pelo ID.

## Contribuição

Se você deseja contribuir para o desenvolvimento deste projeto, fique à vontade para abrir uma *issue* ou fazer um *pull request*.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

