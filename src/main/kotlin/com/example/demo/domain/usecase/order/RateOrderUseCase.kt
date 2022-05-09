package com.example.demo.domain.usecase.order

import com.example.demo.domain.adapter.OrderRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class RateOrderUseCase(private val orderRepository: OrderRepository) {

    fun rate(rate: Double, orderUUID: UUID) =
        orderRepository.rateOrder(rate, orderUUID)
}