package com.example.demo.generic

import com.example.demo.database.ClientDatabaseSimulator
import com.example.demo.database.MerchantDatabaseSimulator
import com.example.demo.domain.entity.Client
import com.example.demo.domain.entity.Merchant

fun populateDatabase() {
    ClientDatabaseSimulator.clientDatabase.add(
        Client(
            name = "Caio",
            age = 20,
            cpf = "195.317.647-00",
            email = "caio.passos@ifood.com.br"
        )
    )

    ClientDatabaseSimulator.clientDatabase.add(
        Client(
            name = "Rodrigo",
            age = 30,
            cpf = "123.456.789-00",
            email = "rodrigo.accorsi@ifood.com.br"
        )
    )

    ClientDatabaseSimulator.clientDatabase.add(
        Client(
            name = "Emmanuel",
            age = 25,
            cpf = "098.765.432-11",
            email = "rodrigo.accorsi@ifood.com.br"
        )
    )

    MerchantDatabaseSimulator.merchantDatabase.add(
        Merchant(
            name = "Backend Restaurant",
            cnpj = "83.646.714/0001-07"
        )
    )
    MerchantDatabaseSimulator.merchantDatabase.add(
        Merchant(
            name = "Frontend Restaurant",
            cnpj = "23.223.115/0001-40"
        )
    )
}