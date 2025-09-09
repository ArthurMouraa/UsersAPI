# Users API - Desafio Backend 

- **Descrição do Projeto**:
    - Aplicação para leitura de usuários
      
  - **Tecnologias utilizadas:**
    - java 21
    - Spring Boot
    - JUnit  & Mockito (Testes unitários)
    - Maven (Build e gerenciamento de dependências)
    - Swagger / OpenAPI (Documentação interativa)

          
## Funcionalidades Implementadas
- CORS habilitado para diferentes origens.
- Leitura de usuários a partir de um arquivo mock-users.json.
- Listagem de usuários com:
  - Paginação (page, page_size).
  - Filtros por nome/email (q), cargo (role), status ativo (is_active).
  - Filtros opcionais por datas de criação (created_after e created_before).
- Busca por ID (GET /users/{id}) com tratamento de erros.
- Tratamento de erros personalizado (incluindo 404 para usuários não encontrados).
- Testes unitários para services e repository.
- Swagger UI para documentação interativa da API.

## Instruções para Iniciar o Projeto

- **Backend**:
    - Passos:
        1. Navegar até a pasta do backend:
            ```bash
            cd users
            ```
        2. Rodar os testes automatizados:
            ```bash
            ./mvnw test
            ```
        3. Compilar e iniciar o servidor:
            ```bash
            ./mvnw spring-boot:run
            ```
    - Observação: A aplicação utiliza Swagger para documentação, acesse: http://localhost:8080/swagger-ui/index.html#/.

## Alguns Exemplos de Uso da API (CURL - Postman ou ferramentas similares)

  ### **1. Listar usuários com filtros e paginação**

**Requisição:**

```bash
curl -X GET "http://localhost:8080/users?page=1&page_size=5&role=manager&is_active=true&q=Felipe" 
```

### **2.  Buscar usuário por ID**

**Requisição:**

```bash
curl -X GET "http://localhost:8080/users/4"
```

### **3.  Usuário não existente**

**Requisição:**

```bash
curl -X GET "http://localhost:8080/users/99" \
```

  

