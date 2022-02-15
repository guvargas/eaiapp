# Eaiapp
O sistema tem a premissa de ser uma aplicação simples para a comunicação entre computadores permitindo que mensagens sejam enviadas entre diferentes computadores utilizando Sockets e Threads.

## Equipe
Gustavo Vargas de Andrade e Lucas Waterkemper Alberton.

## Requisitos Funcionais
- RF1. O sistema deverá permitir manter Pessoas
- RF2. O sistema deverá permitir manter Conversas
- RF3. O sistema deverá permitir que uma pessoa tenha conversas com mais de 1 pessoa
- RF5. O sistema deve permitir a exclusão de mensagens
 
## Requisitos Não Funcionais
- RNF1. Deve ser distribuído e executado simultaneamente em no mínimo 3 clientes (hosts) diferentes.
- RNF2. A comunicação será realizada através de sockets
- RNF3. Os dados enviados entre cliente/cliente estarão no formato String utilizando separadores de ponto e vírgula (“;”) entre as mensagens
- RNF4. A aplicação cliente deve ter interface gráfica
- RNF5. O sistema deve utilizar Threads

## Regras de Negócio
- RN1. Uma pessoa não poderá mudar suas informações de cadastro

## Mensagens trocadas 

`Todas as mensagens serão dividadas com ponto e vírgula (";")`

#### Conexão e envio de mensagem

![Conexão e mensagem](https://user-images.githubusercontent.com/51674297/154132120-6b4191d7-b16a-4a42-95f8-1b2da8011c1c.png)

Construção da mensagem:
```
{Conexão padrão por socket}
```

Construção da resposta:  
```
<{Tipo da mensagem; Indicativo de conexão}>
```

#### Envio de mensagem entre clientes

![Mensagem entre clientes](https://user-images.githubusercontent.com/51674297/154131924-894ace48-02b5-4a74-b3c1-c95628ec4ca4.png)

Construção da mensagem:
```
{Tipo da mensagem; Porta de quem enviou; Nome de quem enviou; Horário; Conteúdo da mensagem}
```

Construção da resposta:  
```
<{Tipo da mensagem; Indicação de recebimento}>
```


## Diagrama de classes

Diagrama de classes sem packages:

![diagrama de classes sem packages](https://user-images.githubusercontent.com/51674297/154133226-2f630bc1-726e-4980-9f50-10f060aa08c1.png)

Diagrama de classes com packages:

![diagrama de classes com packages](https://user-images.githubusercontent.com/51674297/154133312-cf1af74f-cc0f-4e74-bbe1-dded1452e0a8.png)




