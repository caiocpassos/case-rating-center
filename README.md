# 06/05 - Case1 Backend

## Objetivos

 - Criar uma rota REST para receber um POST onde será adicionado uma avaliação a um pedido XPTO.


 - Criar uma rota REST para receber um GET onde será passado o identificador de um estabelecimento e serão retornadas todas as avaliações para este.


 - Criar uma rota REST para receber um GET onde será passado o identificador de um estabelecimento e será retornada uma avaliação média para o mesmo.


## Contratos

### POST - Avaliação

```
{
    "orderId": "",
    "merchantId": "",
    "clientId": "",
    "rate": Intervalo de 1 a 5
}
```

### GET - Lista

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

### GET - Média

```
{
"merchantId": "",
"rate": Média de todas as notas dos pedidos
}
```

# 13/05 - Case 2 Backend

## Objetivos

 - Criar uma camada de cache onde a primeira request deve chegar ao banco de dados, porém a partir da próxima request com os mesmos dados, a consulta deve acontecer no cache, e não mais no banco


### Notas

 - O cache deve ter uma vida útil de 1 minuto para cada informação

## Stack

 - Kotlin
 - Spring
 - Clean Arch

## Link Github

```
https://github.com/caiocpassos/cases-backend
```
