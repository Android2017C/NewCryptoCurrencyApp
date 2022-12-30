package com.example.newcryptocurrencyapp.network

import com.example.newcryptocurrencyapp.model.CoinResponseBase
import com.example.newcryptocurrencyapp.model.CoinResponseBaseItem
import com.example.newcryptocurrencyapp.model.SingleCoinDetailsResponseBase
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiService: ApiService) {

    suspend fun getCoinsData():List<CoinResponseBaseItem> = apiService.getCoins()
    suspend fun getCoinDetailsData(coinId:String):SingleCoinDetailsResponseBase =
        apiService.getCoinById(coinId)
}