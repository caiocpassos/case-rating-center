package com.example.demo.database

import com.example.demo.domain.adapter.MerchantRepository
import com.example.demo.domain.entity.Merchant
import com.example.demo.http.dto.MerchantForm
import org.springframework.stereotype.Repository

@Repository
object MerchantDatabaseSimulator : MerchantRepository {
    val merchantDatabase: MutableList<Merchant> = mutableListOf()

    override fun getAllMerchants(): MutableList<Merchant> {
        return merchantDatabase
    }

    override fun createMerchant(merchant: MerchantForm) {
        merchantDatabase.add(
            Merchant(
                name = merchant.name,
                cnpj = merchant.cnpj
            )
        )
    }
}