package com.example.demo.domain.usecase.client

import com.example.demo.domain.adapter.ClientRepository
import com.example.demo.http.dto.ClientForm
import org.springframework.stereotype.Service

@Service
class CreateClientUseCase(private val clientRepository: ClientRepository) {

    fun create(client: ClientForm) =
        clientRepository.createClient(client)

}