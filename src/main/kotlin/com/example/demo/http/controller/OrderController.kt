package com.example.demo.http.controller

import com.example.demo.domain.usecase.order.CreateOrderUseCase
import com.example.demo.domain.usecase.order.GetAllOrdersUseCase
import com.example.demo.domain.usecase.order.RateOrderUseCase
import com.example.demo.http.dto.OrderForm
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/orders")
class OrderController(
    private val getAllOrdersUseCase: GetAllOrdersUseCase,
    private val createOrderUseCase: CreateOrderUseCase,
    private val rateOrderUseCase: RateOrderUseCase

) {

    @GetMapping
    fun getAllOrders() =
        getAllOrdersUseCase.getAll()

    @PostMapping
    fun createOrder(@RequestBody order: OrderForm) =
        createOrderUseCase.create(order)

    @PostMapping("/{orderUUID}/{rate}") //Será que não poderia ser um PutMapping?
    fun rateOrder(@PathVariable rate: Double, @PathVariable orderUUID: UUID) =
        rateOrderUseCase.rate(rate, orderUUID)
}