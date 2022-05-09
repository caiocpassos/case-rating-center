package com.example.demo.domain.usecase.order

import com.example.demo.domain.adapter.OrderRepository
import org.springframework.stereotype.Service

@Service
class GetAllOrdersUseCase(private val orderRepository: OrderRepository) {

    fun getAll() = orderRepository.getAllOrders()

}