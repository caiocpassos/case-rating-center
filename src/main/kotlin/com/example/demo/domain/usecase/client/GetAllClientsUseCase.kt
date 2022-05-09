package com.example.demo.domain.usecase.client

import com.example.demo.domain.adapter.ClientRepository
import org.springframework.stereotype.Service

@Service
class GetAllClientsUseCase(private val clientRepository: ClientRepository) {

    fun getAll() = clientRepository.getAllClients()

}