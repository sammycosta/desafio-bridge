# desafio-bridge
Repositório criado para o desafio do Processo Seletivo 2022.2 do Laboratório Bridge para a vaga de Bolsista de Desenvolvimento Web Full Stack.

## Desafio
"Você deve criar uma Aplicação Web, que permita que o usuário insira um número
inteiro k e calcule o número de inteiros positivos n menores que k, para os quais
n e n + 1 têm o mesmo número de divisores positivos. (n maior que 1)"

## Tecnologias utilizadas
- Back-end: Java com Spring Boot, Banco de dados com Spring data JPA + MySQL. Rest Controller testado com o uso de Postman
- Front-end: React com TypeScript, aplicação criada a partir do Vite. Conexão com back-end via Axios, e estilização feita com Bootstrap & Material UI
- O ambiente de desenvolvimento foi o Linux Ubuntu 20.04.4, com Visual Studio Code e Spring Tools Suite.
- Testes unitários feitos na back-end, para testar resultados corretos do algoritmo, com o uso do JUnit.

## Executando
Utiliza: Java, Yarn, Node.js, React.js, Vite, Maven, MySQL

`git clone https://github.com/sammycosta/desafio-bridge.git`
### 1º passo: Banco de Dados
É necessário que você possua um Banco de Dados/Schema MySQL de nome desafio-bridge. Crie da forma que preferir, o metódo utilizado no desenvolvimento foi a partir do MySQL Workbench ([Tutorial 1](https://www.alura.com.br/artigos/mysql-do-download-e-instalacao-ate-sua-primeira-tabela)/[Tutorial 2](https://www.mysqltutorial.org/install-mysql-ubuntu/))

A alteração das informações necessárias pode ser feita no arquivo 
`spring-backend/src/main/resources/application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/desafio-bridge
spring.datasource.username=root
spring.datasource.password=password
```
Aqui você pode alterar a port e o usuário/senha relativos a sua conexão no seu banco de dados.

### 2º passo: Back-end
- Executar `spring-backend/src/main/java/br/desafiobridge/samantha/SpringBackendApplication.java` da sua forma preferida (VSCode, alguma IDE Java, etc)
- Ou executar via:
```bash
cd ./spring-backend
mvn clean install
java -jar ./target/desafiobridge-0.0.1-SNAPSHOT.jar
```


### 3º passo: Front-end
- Deixar back-end rodando.
```bash
cd ./react-ts-frontend
yarn install
yarn dev
```
O link da port aparecerá no terminal.