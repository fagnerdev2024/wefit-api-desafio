# Cadastro de Pessoa Jurídica - API REST

Este projeto é uma API REST desenvolvida com Java 17 e Spring Boot para realizar o cadastro de pessoas jurídicas. Ele utiliza banco de dados em memória H2 e segue boas práticas de desenvolvimento, como separação em camadas (DTO, Service, Repository, Controller) e validações com Bean Validation.

## Funcionalidades

- Cadastro de pessoa jurídica com:
    - CNPJ
    - CPF do responsável
    - Nome
    - E-mail e telefone
    - Endereço completo
    - Aceite de termos
- Listagem de todos os cadastros
- Validações de campos obrigatórios, CPF e CNPJ válidos


## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Bean Validation (Jakarta)
- Lombok

## Como rodar o projeto

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/fagnerdev2024/wefit-api-desafio.git
   cd wefit-api-desafio

2. **Compile e rode a aplicação usando Maven:**

   ```bash
   após clonar o repositório, abra o terminal, navegue até o repositorio execute o seguinte comando para compilar e iniciar a aplicação:
   mvnw.cmd spring-boot:run
   Ou, se preferir, compile o JAR e execute:

3. **Acesse a API:**

   ```bash
   Base URL: http://localhost:8080
   Endpoint para cadastro: POST /api/pessoa-juridica
   Endpoint para listar todos: GET /api/pessoa-juridica
   Utilizar o Postman ou qualquer outra ferramenta similar

4. **Testando a API:**
   
   ```bash
   Exemplo de payload para cadastro (JSON):
   {
   "cnpj": "12.345.678/0001-90",
   "cpfResponsavel": "123.456.789-00",
   "nome": "Empresa Exemplo Ltda",
   "email": "contato@empresa.com",
   "telefone": "(11) 91234-5678",
   "endereco": {
   "logradouro": "Rua Exemplo",
   "numero": "123",
   "bairro": "Centro",
   "cidade": "São Paulo",
   "estado": "SP",
   "cep": "01000-000"
   },
   "aceiteTermos": true
   }


5. **Acesso ao banco H2 (opcional)**

   ```bash
   Para acessar o console do banco em memória:
   URL: http://localhost:8080/h2-console
   JDBC URL: jdbc:h2:mem:testdb
   Usuário: sa
   Senha: (deixe em branco)


## Autor

Desenvolvido por **Fagner Tavares de Menezes**  
📧 Email: fagnermenezes2018@gmail.com.com  
🔗 GitHub: (https://github.com/fagnerdev2024/wefit-api-desafio)  
🔗 LinkedIn: (https://www.linkedin.com/in/fagner-menezes-a827b61ab/)