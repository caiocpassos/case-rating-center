package com.example.demo.database

import com.example.demo.domain.adapter.MerchantRepository
import com.example.demo.domain.entity.Merchant
import com.example.demo.domain.entity.Order
import com.example.demo.http.dto.AverageView
import com.example.demo.http.dto.MerchantForm
import org.springframework.stereotype.Repository
import java.util.UUID

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

    override fun getAllRates(merchantUUID: UUID): List<Order> {
        return OrderDatabaseSimulator
                .orderDatabase
                .filter { it.merchantId == merchantUUID && it.rate != null }
    }

    override fun getAverage(merchantUUID: UUID): AverageView {
        val averageList: MutableList<Double> = mutableListOf()

        OrderDatabaseSimulator.orderDatabase
            .filter { it.rate != null }
            .forEach { averageList.add(it.rate!!) }

        return AverageView(
            merchantId = merchantUUID,
            average = (averageList.sum()) / averageList.size
        )
    }
}