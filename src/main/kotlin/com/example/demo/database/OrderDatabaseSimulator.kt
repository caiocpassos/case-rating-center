package com.example.demo.database

import com.example.demo.database.ClientDatabaseSimulator.clientDatabase
import com.example.demo.database.MerchantDatabaseSimulator.merchantDatabase
import com.example.demo.domain.adapter.OrderRepository
import com.example.demo.domain.entity.Order
import com.example.demo.http.dto.OrderForm
import com.example.demo.http.dto.OrderView
import org.springframework.stereotype.Repository
import java.util.UUID
import java.util.stream.Collectors

@Repository
object OrderDatabaseSimulator : OrderRepository {
    val orderDatabase: MutableList<Order> = mutableListOf()

    override fun getAllOrders(): MutableList<OrderView> {
        return orderDatabase.stream().map {
            OrderView(
                orderId = it.orderId,
                clientId = it.clientId,
                clientName = clientDatabase.last { client -> client.clientId == it.clientId }.name,
                merchantUUID = it.merchantId,
                merchantName = merchantDatabase.last { merchant -> merchant.merchantId == it.merchantId }.name,
                rate = it.rate
            )
        }.collect(Collectors.toList())
    }

    override fun createOrder(order: OrderForm) {
        orderDatabase.add(
            Order(
                clientId = order.clientId,
                merchantId = order.merchantId
            )
        )
    }

    override fun rateOrder(rate: Double, orderUUID: UUID) {
        orderDatabase.forEach {
            if(it.orderId == orderUUID) {
                it.rate = rate
            }
        }
    }

}