# DISTRIBUTED SECURITY

### Qual o objetivo deste repositório?

Este repositório foi criado para explicar e demonstrar como utilizar o Keycloak para proteção e autorização dos nossos
recursos entre diferentes microserviços.

### OAuth2.0

#### Para que serve o OAuth2.0?

O OAuth2.0 é um framework de autorização que permite a comunicação entre diferentes aplicações, como por exemplo,
digamos que eu crio uma aplicação de emails, mas eu não irei armazenar emails e nem usuários, então como eu poderia
gerenciar esses emails?

Pedindo autorização para um serviço de emails terceiro, digamos o GMAIL ou OUTLOOK,então o usuário daria a permissão da
minha aplicação acessar e gerenciar esses emails em seu nome.

#### Termos comuns usados no OAuth2.0

1. Protected Resource: É o recurso protegido, digamos que nessa aplicação de emails, o recurso protegido seriam os
   emails que estão armazenados no GMAIL ou OUTLOOK.
2. Resource Owner: O dono do recurso, que pode ser tanto o usuário final como uma aplicação cliente, no nosso caso,
   seria o usuário que possui a conta no GMAIL ou OUTLOOK.
3. Resource Server: O lugar onde está armazenado o recurso protegido, que é responsável por validar se o Client pode ou
   não acessar ao recurso protegido, pois o Resource Server pergunta ao Authorization Server se o token fornecido é
   válido, por exemplo, os servidores da GOOGLE ou MICROSOFT.
4. Client: Seria a aplicação que deseja acessar os recursos protegidos, ela interage com todos os envolvidos, no exemplo
   dado acima, lembrando que o Client tem que estar cadastrado no Authorization Server, caso contrário, ele não poderá
   se comunicar com o Authorization Server, no nosso caso seria a aplicação de
   emails, os Clients podem ser divididos em PÚBLICOS (Apps Mobile, Desktops e etc.) ou PRIVADOS (Microserviços e etc,
   como por exemplo, um microserviço que se comunica com um meio de pagamento).
5. Client Scope: São as permissões que minha aplicação exige, como por exemplo, se ela pode apenas ler emails, se ela
   também pode enviar emails e etc.
6. Authorization Server: Servidor responsável por conceder ou não acesso ao recurso solicitado, no nosso caso iremos
   usar o KEYCLOAK.
7. OAuth Provider: É a junção do Resource Server com o Authorization Server

### Principais OAuth2.0 Grant Types

1. Client Credentials: Usado quando minha autenticação não depende do usuário, como por exemplo, digamos que eu tenha
   uma aplicação que se comunica com uma aplicação de pagamentos, quando o usuário insere as informações do pagamento,
   não é suas credenciais que vão para o serviço de pagamentos, minha aplicação possui uma senha de acesso para se
   comunicar com o meio de pagamento sem precisar da intervenção do usuário.
2. Resource Owner Password: Aqui é basicamente onde temos o login mais "padrão", onde o usuário insere seu login e
   senha, e minha aplicação redireciona para meu Authorization Server, que fica responsável por autenticar o usuário.
3. Authorization Code: É um dos fluxos mais complicados, normalmente usados com SPAS entre outros.
    1. Meu Front End para um recurso protegido, passando seu ID e uma URI de redirecionamento.
    2. Meu Client redireciona o usuário final (Resource Owner) para o Authorization Server.
    3. Meu usuário se autentica, fazendo com que meu Authorization Code gere um código, e retorne esse código pro meu
       Client.
    4. Meu Client faz uma nova requisição para o Authorization Server passando o código anterior.
    5. Por último meu Authorization Server gera um token de acesso e envia para o meu Client.

## Keycloak

### Para que serve o Keycloak?

Ele é utilizado para gerenciar a autorização à recursos protegidos, no caso deste repositório, iremos proteger o nosso
API Gateway com o Keycloak.

### Termos comuns usados no Keycloak

1. Realm: Basicamente é um grande "grupo" onde nós gerenciamos users, scopes, clients, normalmente é criado um realm por
   aplicação, lembrando que eles são independentes.
2. Client: Assim como no protocolo OAuth2.0, os clients são as aplicações que acessarão o meu Authorization Server (
   Keycloak).
3. Client Scope: Aqui eu defino o que minha aplicação pode fazer, por exemplo, se a aplicação poderá enviar emails em
   meu nome, ou apenas visualizá-los e etc.
4. User: São os "usuários", irão fornecer login e senha para gerar nosso token de acesso.
5. User Roles: Aqui é definido o que o usuário pode ou não acessar na minha aplicação.


