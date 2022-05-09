package com.example.demo.domain.adapter

import com.example.demo.domain.entity.Merchant
import com.example.demo.http.dto.MerchantForm

interface MerchantRepository {

    fun getAllMerchants(): MutableList<Merchant>

    fun createMerchant(merchant: MerchantForm)

}