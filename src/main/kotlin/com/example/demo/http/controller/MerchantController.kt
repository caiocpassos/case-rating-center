package com.example.demo.http.controller

import com.example.demo.domain.usecase.merchant.CreateMerchantUseCase
import com.example.demo.domain.usecase.merchant.GetAllMerchantsUseCase
import com.example.demo.domain.usecase.merchant.GetAllRatesUseCase
import com.example.demo.domain.usecase.order.GetRatesAverageUseCase
import com.example.demo.http.dto.MerchantForm
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/merchants")
class MerchantController(
    private val getAllMerchantsUseCase: GetAllMerchantsUseCase,
    private val createMerchantUseCase: CreateMerchantUseCase,
    private val getAllRatesUseCase: GetAllRatesUseCase,
    private val getRatesAverageUseCase: GetRatesAverageUseCase
) {

    @GetMapping
    fun getAllMerchants() =
        getAllMerchantsUseCase.getAll()

    @PostMapping
    fun createMerchant(@RequestBody merchant: MerchantForm) =
        createMerchantUseCase.create(merchant)

    @GetMapping("/rates/{merchantUUID}")
    fun getAllRates(@PathVariable merchantUUID: UUID) =
        getAllRatesUseCase.getAll(merchantUUID)

    @GetMapping("/average/{merchantUUID}")
    fun getRatesAverage(@PathVariable merchantUUID: UUID) =
        getRatesAverageUseCase.get(merchantUUID)
}