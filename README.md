# delivery-acert

<b>Delivery Acert</b>

O projeto consiste em uma api simplificada para controle de delivery de um restaurante, utilizando autenticação via token JWT.

<b>Ferramentas/Techs</b>

    • Java 8
    • Maven
    • Spring
        ◦ SpringBoot
        ◦ SpringData JPA
        ◦ Spring Security
    • Flyway
    • Firebird 3.0
    • Lombok
    • JWT
    • IntelliJ



<b>Diagrama Entidades</b>

![image](https://user-images.githubusercontent.com/20582755/180914992-4e8250d4-7d92-42dc-a38f-e1434b81b866.png)


<b>Executando API</b>

application.properties<br />
Crie um banco Firebird e indique o caminho na propriedade <i>spring.datasource.url</i>.<br />
Informe o usuário e senha do banco nas propriedades <i>spring.datasource.username</i> e <i>spring.datasource.password</i>.

<b>Autenticação/Login</b>

Para realizar autenticação na api, basta fazer uma requisição POST no endpoint “/login” (http://localhost:8080/login) passando no body um email e senha.

![image](https://user-images.githubusercontent.com/20582755/180915033-70b2f60d-f87a-433f-9681-b366500e4faa.png)

O token JWT ficará disponível no header do response, na propriedade Authorization.

![image](https://user-images.githubusercontent.com/20582755/180915046-906198af-b1e0-4b19-8319-bb8fc0a1a589.png)

<b>End-Points</b> <br />
OBS.:Utilize o token JWT no Auth da requisição como Bearer
![image](https://user-images.githubusercontent.com/20582755/180916619-848c8ad1-9a0c-4a38-8e3e-88f9e84d4678.png)


<b>Clientes/Usuários</b> <br />
[GET] Listar Todos - http://localhost:8080/usuarios  <br />
[GET] Buscar - http://localhost:8080/usuarios/id  <br />
[POST] Adicionar - http://localhost:8080/usuarios  <br />
  Exemplo Requestbody: {  <br />
                          "nome": "Rafael",  <br />
                          "email": "rafael@rafael.com",  <br />
                          "senha": "12345" <br />
                        } <br />
[PUT] Atualizar - http://localhost:8080/usuarios/id <br />
  Exemplo Requestbody: { <br />
                          "nome": "Rafael", <br />
                          "email": "rafael@rafael.com", <br />
                          "senha": "12345" <br />
                        } <br />
[DELETE] Excluir - http://localhost:8080/usuarios/id <br />

<b>Pedidos</b> <br />
[GET] Listar Todos - http://localhost:8080/pedidos  <br />
[GET] Buscar - http://localhost:8080/pedidos/id  <br />
[POST] Adicionar - http://localhost:8080/pedidos  <br />
  Exemplo Requestbody: {  <br />
                         "valorTotal": 10.80,  <br />
                         "status": "CRIADO", <br />
                          "cliente_id": { <br />
                            "id": 1 <br />
                          } <br />
                       } <br />
[PUT] Atualizar - http://localhost:8080/pedidos/id <br />
  Exemplo Requestbody: { <br />
                         "valorTotal": 10.80, <br />
                         "status": "FINALIZADO", <br />
                          "cliente_id": { <br />
                            "id": 1 <br />
                          } <br />
                       } <br />
[DELETE] Excluir - http://localhost:8080/pedidos/id <br />

<b>Entregas</b> <br />
[GET] Listar Todos - http://localhost:8080/entregas  <br />
[GET] Buscar - http://localhost:8080/entregas/id  <br />
[POST] Adicionar - http://localhost:8080/entregas  <br />
  Exemplo Requestbody: { <br />
                          "status": "CRIADO", <br />
                          "pedido_id": { <br />
                            "id": 1 <br />
                          } <br />
                        } <br />
[PUT] Atualizar - http://localhost:8080/entregas/id <br /> 
  Exemplo Requestbody: { <br />
                          "status": "FINALIZADO", <br />
                          "pedido_id": { <br />
                            "id": 1 <br />
                          } <br />
                        } <br />
[DELETE] Excluir - http://localhost:8080/entregas/id <br />

Se você utiliza o Insomina para fazer suas requisições, clique no botão abaixo.<br /> 
[![Run in Insomnia}](https://insomnia.rest/images/run.svg)](https://insomnia.rest/run/?label=Delivery%20Acert%20API&uri=https%3A%2F%2Fraw.githubusercontent.com%2Frafaelmodesto%2Fdelivery-acert%2Fmain%2FInsomnia.json)

