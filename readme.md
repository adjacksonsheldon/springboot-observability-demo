# Elastic Observability Lab

Projeto desenvolvido com **Spring Boot + GraphQL** com foco em demonstrar conceitos de observabilidade utilizando a Elastic Stack.

A aplicação simula um catálogo de cursos e categorias e serve como base para monitoramento de:

- Logs
- Métricas
- Traces
- Health checks
- Containers Docker
- Performance da aplicação

> Todo o monitoramento deste projeto foi configurado considerando a aplicação rodando via Docker Compose.
>
> A stack de observabilidade não está configurada para monitorar a aplicação executando localmente fora dos containers.

---

# 🚀 Tecnologias utilizadas

## Aplicação

- Java 17
- Spring Boot
- Spring GraphQL
- Spring Data JPA
- MySQL
- Lombok

## Observabilidade

- Elasticsearch
- Kibana
- Filebeat
- Metricbeat
- Heartbeat
- Elastic APM
- Docker Compose

---

# 🐳 Arquitetura

| Serviço | Responsabilidade |
|---|---|
| Elasticsearch | Armazenamento de logs, métricas e traces |
| Kibana | Visualização dos dados |
| Filebeat | Coleta de logs |
| Metricbeat | Coleta de métricas |
| Heartbeat | Monitoramento de disponibilidade |
| Elastic APM | Rastreamento de transações |
| MySQL | Banco de dados |
| Spring Boot App | Aplicação monitorada |

---

# ▶️ Como executar

## Pré-requisitos

- Docker
- Docker Compose

---

## 1. Criar diretório obrigatório do Elasticsearch

A pasta abaixo será utilizada como volume persistente do Elasticsearch:

```bash
mkdir -p elasticsearch_data
````

---

## 2. Ajustar permissões necessárias

### Elasticsearch

```bash id="i8hlmq"
sudo chown -R 1000:1000 ./elasticsearch_data
chmod -R 775 ./elasticsearch_data
```

### Metricbeat

```bash id="r3txhi"
sudo chown root:root ./elastic/beats/metric/metricbeat.yml
sudo chmod 644 ./elastic/beats/metric/metricbeat.yml
```

### Filebeat

```bash id="2fvd9f"
sudo chown root:root ./docker/filebeat/filebeat.yml
sudo chmod 644 ./docker/filebeat/filebeat.yml
```

### APM Server

```bash id="m6hajp"
sudo chown root:root ./elastic/apm/apm-server.yml
sudo chmod 644 ./elastic/apm/apm-server.yml
```

---

## 3. Criar a imagem da aplicação

Antes de subir o ambiente, gere a imagem Docker da aplicação Spring Boot:

```bash id="lpohz8"
docker build -f docker/Dockerfile -t springboot-observability-demo .
```

---

## 4. Subir a aplicação

```bash id="uav1d3"
docker compose -f docker-compose-full.yml up
```

---

# 📊 Serviços disponíveis

| Serviço       | URL                                                              |
| ------------- | ---------------------------------------------------------------- |
| Spring Boot   | [http://localhost:8080](http://localhost:8080)                   |
| GraphiQL      | [http://localhost:8080/graphiql](http://localhost:8080/graphiql) |
| Kibana        | [http://localhost:5601](http://localhost:5601)                   |
| Elasticsearch | [http://localhost:9200](http://localhost:9200)                   |
| Elastic APM   | [http://localhost:8200](http://localhost:8200)                   |

---

# 🔍 O que pode ser visualizado

* Logs da aplicação
* Logs de erro
* Métricas dos containers
* Consumo de CPU e memória
* Disponibilidade da aplicação
* Traces distribuídos
* Tempo de resposta das requisições

---

# 🧪 Testando a aplicação

## Query: Listar categorias

```graphql id="42o6j4"
query {
  categories {
    id
    name
  }
}
```

---

## Mutation: Criar categoria

```graphql id="n9z7u5"
mutation {
  createCategory(
    category: {
      name: "Tecnologia"
      description: "Cursos relacionados a tecnologia"
    }
  ) {
    id
    name
    description
  }
}
```

---
# 📌 Objetivo

Projeto criado para fins de estudo e demonstração prática de observabilidade com Spring Boot e Elastic Stack.