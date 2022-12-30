package com.example.newcryptocurrencyapp.repository

import com.example.newcryptocurrencyapp.model.CoinResponseBase
import com.example.newcryptocurrencyapp.model.CoinResponseBaseItem
import com.example.newcryptocurrencyapp.model.SingleCoinDetailsResponseBase
import com.example.newcryptocurrencyapp.network.ApiServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import java.util.concurrent.Flow
import javax.inject.Inject

class CryptoCoinRepository @Inject constructor(private val apiServiceImpl: ApiServiceImpl) {

    fun getCoinData(): kotlinx.coroutines.flow.Flow<List<CoinResponseBaseItem>> = flow {
        emit(apiServiceImpl.getCoinsData())
    }.flowOn(Dispatchers.IO)

    fun getCoinDetailsData(coinid : String): kotlinx.coroutines.flow.Flow<SingleCoinDetailsResponseBase> = flow {
        emit(apiServiceImpl.getCoinDetailsData(coinid))
    }.flowOn(Dispatchers.IO)
}