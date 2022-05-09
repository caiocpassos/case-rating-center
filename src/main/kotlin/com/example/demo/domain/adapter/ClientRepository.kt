package com.example.demo.domain.adapter

import com.example.demo.http.dto.ClientForm
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client

interface ClientRepository {

    fun getAllClients(): MutableList<com.example.demo.domain.entity.Client>

    fun createClient(client: ClientForm)

}