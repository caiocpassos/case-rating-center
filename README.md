# RATING CENTER - CASE BACKEND

## O que é?

 - Esse é apenas um criado com o objetivo de praticar boas práticas da programação.


 - Ele consiste em uma aplicação backend cujo objetivo é dar notas à pedidos existentes feitos em algum restaurante por algum cliente. Essas notas precisam ser armazenadas em um banco de dados para que sejam retornadas depois.


 - Também será possível armazenar a média de um restaurante, que será baseada nas notas de todos os pedidos já feitos nele. Essa média também poderá ser retornada.


 - A aplicação será desenvolvida utilizando a linguagem de programação Kotlin, o framework spring, e algumas outras tecnologias para facilitar o ambiente da aplicação (docker, localstack, gradle). O banco de dados usado será DynamoDb, mas pode ser mudado sem problemas devido a arquitetura utilizada.


 - O projeto foi estruturado baseado nos princípios de Clean-Arch, com o objetivo de facilitar a manutenção e adaptabilidade do código caso este precise de outras tecnologias para serem implementadas.

## 06/05 - Passo 1

### Objetivos

 - Criar uma rota REST para receber um POST onde será adicionado uma avaliação a um pedido XPTO.


 - Criar uma rota REST para receber um GET onde será passado o identificador de um estabelecimento e serão retornadas todas as avaliações para este.


 - Criar uma rota REST para receber um GET onde será passado o identificador de um estabelecimento e será retornada uma avaliação média para o mesmo.


 - Criar uma lista para simular um banco de dados

### Contratos

#### POST - Avaliação

```
{
    "orderId": "",
    "merchantId": "",
    "clientId": "",
    "rate": Intervalo de 1 a 5
}
```

#### GET - Lista

```
[{
    "orderId": "",
    "merchantId": "",
    "clientId": "",
    "rate": Intervalo de 1 a 5
}
{
    "orderId": "",
    "merchantId": "",
    "clientId": "",
    "rate": Intervalo de 1 a 5
}
{
    "orderId": "",
    "merchantId": "",
    "clientId": "",
    "rate": Intervalo de 1 a 5
}]
```

#### GET - Média

```
{
"merchantId": "",
"rate": Média de todas as notas dos pedidos
}
```

## 13/05 - Passo 2

### Objetivos

 - Criar uma camada de cache onde a primeira request deve chegar ao banco de dados, porém a partir da próxima request com os mesmos dados, a consulta deve acontecer no cache, e não mais no banco


 - Criar a cache no formato de lista, como foi feito no banco de dados

#### Notas

 - O cache deve ter uma vida útil de 1 minuto para cada informação

## 27/05 - Passo 3

### Objetivos

 - Realizar um estudo para entender qual o melhor banco de dados para usar nessa aplicação.

 - Deve-se levar em consideração princípios 
 
#### Notas
 - Muita escrita no banco e muita leitura (ao mesmo tempo)
 - Não precisa ser Real Time
 - Necessário retornar a nota (armazenando ou calculando em todo o retorno)

## 12/06 - Passo 4

### Objetivos

 - Implementar o banco escolhido no passo 3.


 - Implementar o banco pensando em um cenário corporativo (visando que será implementado em uma empresa real).


 - Não ignorar boas práticas.


 - Entender a melhor forma de criar as tabelas, lembrando que é preciso retornar tanto as notas quanto suas médias


 - Todas as rotas criadas no passo 1 devem estar conectadas com o banco, que antes era apenas uma lista


### Método

 - Criar um arquivo docker-compose.yml, que será usado como forma de subir os containeres necessários para a aplicação do projeto (em alguns casos não será necessário).


 - Caso for utilizar dynamodb, uma das maneiras de fazer a aplicação é utilizando o localstack, que pode subir através de um container do docker.


# Stack

 - Kotlin
 - Spring
 - Banco de Dados (Minha escolha: DynamoDB)
 - Clean Arch

# Link Github

```
https://github.com/caiocpassos/case-rating-center
```

Encontrar uma maneira de chamar a url do localstack através do arquivo application.properties
