package com.example.demo.domain.usecase.order

import com.example.demo.domain.adapter.OrderRepository
import com.example.demo.http.dto.OrderForm
import org.springframework.stereotype.Service

@Service
class CreateOrderUseCase(private val orderRepository: OrderRepository) {

    fun create(order: OrderForm) =
        orderRepository.createOrder(order)

}