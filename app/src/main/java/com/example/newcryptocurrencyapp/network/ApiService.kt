package com.example.newcryptocurrencyapp.network

import com.example.newcryptocurrencyapp.model.CoinResponseBase
import com.example.newcryptocurrencyapp.model.CoinResponseBaseItem
import com.example.newcryptocurrencyapp.model.SingleCoinDetailsResponseBase
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinResponseBaseItem>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): SingleCoinDetailsResponseBase
}