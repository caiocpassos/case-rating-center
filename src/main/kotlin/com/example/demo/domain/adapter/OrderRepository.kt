package com.example.demo.domain.adapter

import com.example.demo.http.dto.OrderForm
import com.example.demo.http.dto.OrderView
import java.util.UUID

interface OrderRepository {

    fun getAllOrders(): MutableList<OrderView>

    fun createOrder(order: OrderForm)

    fun rateOrder(rate: Double, orderUUID: UUID)

}