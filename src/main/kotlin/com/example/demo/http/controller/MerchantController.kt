package com.example.demo.http.controller

import com.example.demo.domain.usecase.merchant.CreateMerchantUseCase
import com.example.demo.domain.usecase.merchant.GetAllMerchantsUseCase
import com.example.demo.http.dto.MerchantForm
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/merchants")
class MerchantController(
    private val getAllMerchantsUseCase: GetAllMerchantsUseCase,
    private val createMerchantUseCase: CreateMerchantUseCase
) {

    @GetMapping
    fun getAllMerchants() =
        getAllMerchantsUseCase.getAll()

    @PostMapping
    fun createMerchant(@RequestBody merchant: MerchantForm) =
        createMerchantUseCase.create(merchant)


}