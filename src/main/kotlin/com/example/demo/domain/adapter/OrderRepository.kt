package com.example.demo.domain.adapter

import com.example.demo.domain.entity.Order
import com.example.demo.http.dto.OrderForm

interface OrderRepository {

    fun getAllOrders(): MutableList<Order>

    fun createOrder(order: OrderForm)

}