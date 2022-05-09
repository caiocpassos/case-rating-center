package com.example.demo.database

import com.example.demo.domain.adapter.OrderRepository
import com.example.demo.domain.entity.Order
import com.example.demo.http.dto.OrderForm
import org.springframework.stereotype.Repository

@Repository
object OrderDatabaseSimulator : OrderRepository {
    val orderDatabase: MutableList<Order> = mutableListOf()

    override fun getAllOrders(): MutableList<Order> {
        return orderDatabase
    }

    override fun createOrder(order: OrderForm) {
        orderDatabase.add(
            Order(
                clientId = order.clientId,
                merchantId = order.merchantId
            )
        )
    }

}