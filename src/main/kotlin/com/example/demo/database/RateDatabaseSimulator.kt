package com.example.demo.database
//
//import com.example.demo.database.cache.RateCacheSimulator
//import com.example.demo.domain.exceptions.NotFoundException
//import com.example.demo.domain.adapter.RateRepository
//import com.example.demo.domain.entity.Rate
//import com.example.demo.domain.entity.RateAverage
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//import org.springframework.stereotype.Repository
//
//object RateDatabaseSimulator : RateRepository{
//    private val rateDatabase: MutableList<Rate> = mutableListOf()
//
//    override fun addRate(rate: Rate) {
//        rateDatabase.add(rate)
//    }
//
//    override fun getAllRates(): MutableList<Rate> {
//        return rateDatabase
//    }
//
////    override fun getRatesByMerchantId(merchantId: String): MutableList<Rate> = withContext(Dispatchers.IO) {
////        val cacheQuery = RateCacheSimulator.rateCache[merchantId]
////
////        cacheQuery?.let {
////            return@withContext cacheQuery
////        }
////
////        val databaseQuery = rateDatabase.filter { it.merchantId == merchantId } as MutableList<Rate>
////
////        if (databaseQuery.isEmpty()) {
////            throw NotFoundException("Error! MerchantId not found")
////        }
////
////        RateCacheSimulator.addToCache(merchantId, databaseQuery)
////
////        CoroutineScope(Dispatchers.IO).launch{
////            delay(60000)
////            RateCacheSimulator.removeFromCache(merchantId)
////        }
////
////        databaseQuery
////    }
//
//    override suspend fun getMerchantAverage(merchantId: String): RateAverage = withContext(Dispatchers.IO) {
//
//        val cacheQuery = RateCacheSimulator.rateCache[merchantId]
//
//        cacheQuery?.let {
//            val filteredRateCache = cacheQuery.map { it.value }
//            val soma = filteredRateCache.reduce { acc, current -> acc + current }
//
//            return@withContext RateAverage(
//                merchantId = merchantId,
//                rateValue = (soma / filteredRateCache.size).toDouble()
//            )
//        }
//
//        val databaseQuery = rateDatabase.filter { it.merchantId == merchantId } as MutableList<Rate>
//
//        if (databaseQuery.isEmpty()) {
//            throw NotFoundException("ERROR! MerchantId not found")
//        }
//
//        RateCacheSimulator.addToCache(merchantId, databaseQuery)
//
//        CoroutineScope(Dispatchers.IO).launch {
//            delay(60000)
//            RateCacheSimulator.removeFromCache(merchantId)
//        }
//
//        val soma = databaseQuery.map { it.value }.reduce { acc, current -> acc + current }
//
//        RateAverage(
//            merchantId = merchantId,
//            rateValue = (soma / databaseQuery.size).toDouble()
//        )
//
//    }
//}