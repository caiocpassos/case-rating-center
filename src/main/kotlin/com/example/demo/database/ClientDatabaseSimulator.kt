package com.example.demo.database

import com.example.demo.domain.adapter.ClientRepository
import com.example.demo.domain.entity.Client
import com.example.demo.http.dto.ClientForm
import org.springframework.stereotype.Repository

@Repository
object ClientDatabaseSimulator : ClientRepository {
    val clientDatabase: MutableList<Client> = mutableListOf()

    override fun getAllClients(): MutableList<Client> {
        return clientDatabase
    }

    override fun createClient(client: ClientForm) {
        clientDatabase.add(
            Client(
                name = client.name,
                age = client.age,
                cpf = client.cpf,
                email = client.email
            )
        )
    }
}