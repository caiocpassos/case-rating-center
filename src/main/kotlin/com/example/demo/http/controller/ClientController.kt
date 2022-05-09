package com.example.demo.http.controller

import com.example.demo.domain.usecase.client.CreateClientUseCase
import com.example.demo.domain.usecase.client.GetAllClientsUseCase
import com.example.demo.http.dto.ClientForm
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/clients")
class ClientController(
    private val getAllClientsUseCase: GetAllClientsUseCase,
    private val createClientUseCase: CreateClientUseCase
) {

    @GetMapping
    fun getAllClients() =
        getAllClientsUseCase.getAll()

    @PostMapping
    fun createClient(@RequestBody client: ClientForm) =
        createClientUseCase.create(client)

}