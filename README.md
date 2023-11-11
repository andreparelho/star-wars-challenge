
# StarWars Challenge

Olá! Este é o meu projeto para o desafio back-end proposto pela AmeDigital. O objetivo é desenvolver uma API para fornecer informações sobre planetas do universo Star Wars.

## Requisitos
- A API deve ser RESTful.
- Cada planeta deve ter as seguintes informações obtidas manualmente do banco de dados da aplicação:
    - Nome
    - Clima
    - Terreno
- Para cada planeta, também devemos ter a quantidade de aparições em filmes, obtidas através da API pública do Star Wars: SWAPI.

## Funcionalidades
- Adicionar um planeta (com nome, clima e terreno).
- Listar planetas.
- Buscar por nome. 
- Buscar por ID.
- Remover planeta.

## Tecnologias Utilizadas
- Java
- SpringBoot Web
- Bando de dados H2 para testes




## Como rodar o projeto

Clone o projeto

```bash
git clone https://github.com/andreparelho/star-wars-challenge.git
```

Navegue até o diretorio do projeto
```bash
cd app.star-wars-challenge
```

Execute a aplicação
```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em http://localhost:8080

Para visualizar o banco de dados H2
http://localhost:8080/h2-console

## Endpoints
- `POST /create-planet:` adiciona um novo planeta; 
- `GET /list-planets:` lista todos os planetas cadastrados;
- `GET /get-planet-by-name:` busca um planeta pelo nome;
- `GET /get-planet-by-id:` busca um planeta pelo id;
- `DELETE /delete-planet-by-id:` deleta um planeta pelo id;



## Referência

 - [Desafio](https://github.com/AmeDigital/challenge-back-end-hit)
