# Sistema de Agendamento de Consultas

API REST para gerenciamento de médicos, pacientes e consultas de uma clínica. O projeto utiliza Kotlin e Spring Boot, com persistência em MySQL e documentação da API por meio do Swagger/OpenAPI.

## 🎯 Sobre o projeto

O **Clínica +Saúde** é um backend para gerenciamento de uma clínica médica, desenvolvido para oferecer uma base organizada e confiável para o cadastro de profissionais, pacientes e consultas.

O backend permite:

- Cadastrar médicos e pacientes;
- Agendar consultas médicas;
- Impedir conflitos de horário;
- Aplicar validações rígidas às regras de negócio;
- Cancelar consultas com registro do motivo.

## 🧩 Recursos e arquitetura

A aplicação foi estruturada com foco em persistência, organização e integridade dos dados:

- Persistência de dados com **MySQL**;
- Gerenciamento do ciclo de vida do schema com **Flyway**;
- Mapeamento de entidades relacionais com **Spring Data JPA**;
- Organização da aplicação em camadas de controller, service, repository, model e DTO;
- Validação de dados com **Bean Validation**;
- Tratamento global de exceções;
- Uso de funções de extensão idiomáticas do **Kotlin** na camada de transformação;
- Desenvolvimento de uma API REST documentada com **Swagger/OpenAPI**.

## 🚀 Começando

Siga as instruções abaixo para configurar o ambiente e executar a aplicação localmente.

## 📋 Pré-requisitos

Antes de começar, instale:

- Java 21 ou superior;
- MySQL;
- Git, caso o projeto seja clonado de um repositório;
- Um cliente para executar comandos SQL, como o MySQL Workbench ou o terminal.

O projeto possui Maven Wrapper, portanto não é necessário instalar o Maven separadamente.

## 🔧 Instalação

### 1. Clone o projeto

```bash
git clone URL_DO_REPOSITORIO
cd api-clinica
```

### 2. Crie o banco de dados

No MySQL, crie o banco utilizado pela aplicação:

```sql
CREATE DATABASE clinica_saude_db;
```

### 3. Configure as credenciais

Copie o arquivo de exemplo `.env.example` para `.env`, na raiz do projeto.

No Windows PowerShell:

```powershell
Copy-Item .env.example .env
```

No Linux/macOS:

```bash
cp .env.example .env
```

Edite o arquivo `.env` com os dados do seu banco:

```dotenv
DB_URL=jdbc:mysql://localhost:3306/clinica_saude_db
DB_USERNAME=root
DB_PASSWORD=sua-senha
```

O Spring Boot carrega esse arquivo automaticamente durante a inicialização. O `.env` contém informações sensíveis, está incluído no `.gitignore` e não deve ser enviado ao GitHub.

## ▶️ Executando a aplicação

### Windows

```powershell
.\mvnw.cmd spring-boot:run
```

### Linux/macOS

```bash
./mvnw spring-boot:run
```

A aplicação será executada em:

```text
http://localhost:8080
```

As tabelas do banco são criadas e versionadas automaticamente pelo Flyway durante a inicialização.

## 📦 Implantação

Para gerar o pacote da aplicação:

### Windows

```powershell
.\mvnw.cmd clean package
```

### Linux/macOS

```bash
./mvnw clean package
```

O arquivo `.jar` será gerado no diretório `target/`. Em um ambiente de produção, configure `DB_URL`, `DB_USERNAME` e `DB_PASSWORD` como variáveis ou secrets do ambiente de hospedagem. Não coloque credenciais diretamente no código ou no repositório.

## 🛠️ Construído com

- [Kotlin](https://kotlinlang.org/) — linguagem de programação;
- [Java 21](https://www.oracle.com/java/technologies/downloads/) — plataforma de execução;
- [Spring Boot](https://spring.io/projects/spring-boot) — framework da aplicação;
- [Spring Web MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html) — construção da API REST;
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa) — persistência de dados;
- [MySQL](https://www.mysql.com/) — banco de dados;
- [Flyway](https://documentation.red-gate.com/flyway) — versionamento do banco;
- [Springdoc OpenAPI](https://springdoc.org/) — documentação da API;
- [Maven](https://maven.apache.org/) — gerenciamento do projeto e dependências.

## 📚 Documentação da API

Os endpoints, parâmetros, modelos e exemplos estão disponíveis no Swagger:

- [Swagger UI](http://localhost:8080/swagger-ui/index.html)
- [OpenAPI JSON](http://localhost:8080/v3/api-docs)

## 🖇️ Colaborando

Para contribuir:

1. Crie um fork do projeto;
2. Crie uma branch para sua alteração;
3. Faça as alterações e execute os testes;
4. Abra um Pull Request descrevendo o que foi modificado.


## 📌 Versão

Este projeto está em desenvolvimento e utiliza a versão `0.0.1-SNAPSHOT`.
