# Desafio Java Spring Boot

API Rest para gerenciamento de boletos bancários voltados para microempresas.

## Funcionalidades

* Criar Boleto
* Listar Boletos
* Ver Detalhes
* Pagar um Boleto
* Cancelar um Boleto

### Configuração do Projeto

Java 8, Spring Boot, Maven para gerenciamento de dependências, JUnit para testes unitários e H2 Database para banco de dados em memória

### Comandos

Rodar o Projeto: mvn spring-boot:run. P.S.: Se o Maven não funcionar tente executar pelo Eclipse ou ferramenta semelhante.

### Regras de negócio:

Até 10 dias após o vencimento --> Multa de 0.005 ao dia
Depois de 10 dias --> Multa de 0.01 ao dia