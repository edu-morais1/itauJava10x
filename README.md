# itauJava10x

API REST para receber transacoes e retornar estatisticas, conforme o desafio tecnico do Itau (backend).

**Desafio:** https://github.com/feltex/desafio-itau-backend

## Requisitos

- Java 17
- Maven 3.9+

## Como rodar

```bash
./mvnw spring-boot:run
```

Aplicacao: `http://localhost:8080`

## Endpoints

### POST /transacao

Cria uma transacao.

Request:
```json
{
  "valor": 123.45,
  "dataHora": "2020-08-07T12:34:56.789-03:00"
}
```

Respostas:
- `201 Created`
- `422 Unprocessable Entity` (validacao)
- `400 Bad Request` (JSON invalido)

Validacoes:
- `valor` >= 0
- `dataHora` obrigatoria e nao pode ser no futuro

### DELETE /transacao

Remove todas as transacoes em memoria.

Respostas:
- `200 OK`

### GET /estatistica

Retorna estatisticas das transacoes dos ultimos 60 segundos.

Response:
```json
{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.456,
  "min": 12.34,
  "max": 123.56
}
```

## Swagger / OpenAPI

Swagger UI:
`http://localhost:8080/swagger-ui.html`

OpenAPI JSON:
`http://localhost:8080/v3/api-docs`

## Notas

- Dados armazenados em memoria (sem banco de dados).
- Janela de estatisticas configurada em `application.yml`:
  - `estatistica.segundos: 60`
