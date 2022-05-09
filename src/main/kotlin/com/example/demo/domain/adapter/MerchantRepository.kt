package com.example.demo.domain.adapter

import com.example.demo.domain.entity.Merchant
import com.example.demo.domain.entity.Order
import com.example.demo.http.dto.AverageView
import com.example.demo.http.dto.MerchantForm
import java.util.UUID

interface MerchantRepository {

    fun getAllMerchants(): MutableList<Merchant>

    fun createMerchant(merchant: MerchantForm)

    fun getAllRates(merchantUUID: UUID): List<Order>

    fun getAverage(merchantUUID: UUID): AverageView

}