# Eaiapp
O sistema tem a premissa de ser uma aplicação simples para a comunicação entre computadores permitindo que mensagens sejam enviadas entre diferentes computadores utilizando Sockets e Threads.

# Equipe
Gustavo Vargas de Andrade e Lucas Waterkemper Alberton.

# Requisitos Funcionais
- RF1. O sistema deverá permitir manter Pessoas
- RF2. O sistema deverá permitir manter Conversas
- RF3. O sistema deverá permitir que uma pessoa tenha conversas com mais de 1 pessoa
- RF5. O sistema deve permitir a exclusão de mensagens
 
# Requisitos Não Funcionais
- RNF1. Deve ser distribuído e executado simultaneamente em no mínimo 3 clientes (hosts) diferentes.
- RNF2. A comunicação será realizada através de sockets
- RNF3. Os dados enviados entre cliente/cliente estarão no formato String utilizando separadores de ponto e vírgula (“;”) entre as mensagens
- RNF4. A aplicação cliente deve ter interface gráfica
- RNF5. O sistema deve utilizar Threads

# Regras de Negócio
- RN1. Uma pessoa não poderá mudar suas informações de cadastro

# Mensagens trocadas 

- Todas as mensagens serão dividadas com ponto e vírgula (";")

![btw clientes](https://user-images.githubusercontent.com/51674297/153309310-3890b02c-77b3-41f9-8d5c-69c816cb89ae.png)
- Construção da mensagem = {Tipo; Quem envia; Quem recebe; Data; Conteúdo da mensagem}

![Untitled](https://user-images.githubusercontent.com/51674297/153308767-8710f7c4-f963-4d2b-b825-785a94e8041a.png)
- Construção da mensagem = {Tipo; Quem envia; Quem manda; Nome da conversa}

![Cadastro](https://user-images.githubusercontent.com/51674297/153309058-0b6d7993-5699-44d2-9fd8-ab7539729eb1.png)
- Construção da mensagem = {Tipo; IP de quem envia; Login; Senha}

![Login](https://user-images.githubusercontent.com/51674297/153309178-70a789fd-f3d5-48ff-b513-99cc07ca9228.png)
- Construção da mensagem = {Tipo; IP de quem envia; Login; Senha}

# Diagrama de classes

![image](https://user-images.githubusercontent.com/51674297/153311384-e605dcee-dfdf-4151-b568-7b4a84c12fb2.png)





