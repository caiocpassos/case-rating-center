package com.example.demo.database.cache

import com.example.demo.domain.entity.Rate
import com.example.demo.domain.exceptions.NotFoundException
import org.springframework.stereotype.Repository

@Repository
object RateCacheSimulator {
    val rateCache: MutableMap<String, MutableList<Rate>> = mutableMapOf()

    fun addToCache(merchantId: String, rates: MutableList<Rate>) {
        rateCache[merchantId] = rates
    }

    fun removeFromCache(merchantId: String) {
        rateCache.remove(merchantId)
    }
}