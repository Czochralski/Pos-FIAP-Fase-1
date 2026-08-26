# Restaurantes API

API REST desenvolvida com **Java 21** e **Spring Boot** para
gerenciamento de usuários.

O projeto utiliza uma **arquitetura em camadas**, separando
responsabilidades entre controllers, services, repositories, DTOs,
mappers, validators e componentes de segurança.

## Tecnologias

-   Java 21
-   Spring Boot
-   Spring Web MVC
-   Spring Data JPA / Hibernate
-   PostgreSQL 17
-   Flyway
-   Spring Security
-   BCrypt
-   MapStruct
-   Lombok
-   Maven
-   Docker e Docker Compose
-   OpenAPI / Swagger UI
-   Postman

## Pré-requisitos

Para executar a aplicação utilizando Docker Compose, é necessário ter:

| Requisito | Descrição |
|---|---|
| Docker | Necessário para executar os containers da API e do PostgreSQL. |
| Git | Necessário para clonar o repositório. |
| Postman | Recomendado para executar e validar os testes da API. |

## Estrutura do Projeto

```
/
├── config
├── controller
├── dto
├── exceptions
├── mapper
├── model
├── repository
├── security
├── service
└── validator
```

### Arquitetura / Camadas

-   **Config**: Contém configurações gerais da aplicação
-   **Controller**: Recebe e responde às requisições HTTP.
-   **DTO**: Objetos específicos para requisições e respostas.
-   **Exceptions**: Contém as exceções da aplicação e o tratamento padronizado dos erros.
-   **Mapper**: Conversão entre entidades e DTOs utilizando MapStruct.
-   **Model**: Contém as entidades que representam os dados persistidos no banco.
-   **Repository**: Acesso aos dados através do Spring Data JPA.
-   **Security**: Autenticação e configuração do Spring Security.
-   **Service**: Concentra as regras de negócio.
-   **Validator**: Validações específicas das regras da aplicação.

## Versionamento

A API utiliza o prefixo `/v1`.

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/v1/usuarios` | Cadastrar usuário |
| GET | `/v1/usuarios?nome={nome}` | Buscar usuários por nome |
| PUT | `/v1/usuarios/{id}` | Atualizar usuário |
| PATCH | `/v1/usuarios/{id}/senha` | Alterar senha |
| DELETE | `/v1/usuarios/{id}` | Excluir usuário |

O `id` dos usuários é um UUID gerado pela aplicação.

## Autenticação

A API utiliza **Spring Security com HTTP Basic Authentication**.

O cadastro de usuário é permitido sem autenticação. As demais operações
exigem credenciais válidas.

As credenciais são o `login` e a `senha` do usuário cadastrado. A senha é
armazenada utilizando **BCrypt**, não sendo persistida em texto puro.

No Postman:

```
Authorization → Basic Auth
```

## Banco de dados

A aplicação utiliza **PostgreSQL 17**.

A estrutura do banco é controlada pelo **Flyway**. As migrações ficam
em:

```
src/main/resources/db/migration
```
Assim, a criação e evolução do schema ficam sob responsabilidade do
Flyway.

## Variáveis de ambiente

O projeto utiliza variáveis de ambiente para configurar a conexão com o
banco.

O arquivo `.env` fica na raiz do projeto e é utilizado pelo Docker
Compose.

Exemplo:

``` env
DATASOURCE_USERNAME=postgres
DATASOURCE_PASSWORD=postgres
DATASOURCE_DB=restaurantes
```

O `.env` não deve ser versionado. O projeto possui um `.env.example`
com as variáveis necessárias para configuração.

Para configurar o ambiente, copie o arquivo de exemplo:

No Windows:

``` powershell
copy .env.example .env
```

## Execução com Docker

Com o Docker em execução, na raiz do projeto:

``` powershell
docker compose up --build
```

O Compose inicia a API e o PostgreSQL, configura a persistência do banco
por volume e aguarda o PostgreSQL estar saudável antes de iniciar a API.

A API ficará disponível em:

```
http://localhost:8080
```

Para parar os containers:

``` powershell
docker compose down
```

Para remover também o volume e os dados persistidos:

``` powershell
docker compose down -v
```

### Execução sem Docker

Caso a aplicação seja executada diretamente no ambiente local, também será necessário:

- Java 21+
- PostgreSQL 17
- Maven (ou utilizar o Maven Wrapper incluído no projeto)
  

## Swagger / OpenAPI

Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

Especificação OpenAPI:

```
http://localhost:8080/v3/api-docs
```

## Postman

O projeto possui uma Collection do Postman para validação dos endpoints,
contemplando cenários de sucesso e erro.

Os cenários estão organizados em:

- cadastro de usuário;
- e-mail duplicado;
- login duplicado;
- campos inválidos no cadastro;
- autenticação com credenciais corretas e incorretas;
- busca de usuários;
- atualização de usuário com sucesso;
- atualização com campos inválidos;
- atualização de usuário inexistente;
- alteração de senha com sucesso;
- alteração de senha para usuário inexistente;
- alteração de senha com campo inválido;
- exclusão de usuário com sucesso;
- exclusão de usuário inexistente.

A Collection utiliza variáveis para facilitar a execução dos cenários.
O UUID retornado pelo cadastro com sucesso é armazenado automaticamente
na variável `usuarioId` e utilizado nos endpoints que dependem do
identificador do usuário.

Para executar os cenários que dependem do ID, execute primeiro o
cadastro com sucesso.

### Testes de API

Importe a coleção localizada em:

./collections/TechChallengeFase1.postman_collection.json

