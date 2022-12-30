package com.example.newcryptocurrencyapp.common

import com.example.newcryptocurrencyapp.model.CoinResponseBase
import com.example.newcryptocurrencyapp.model.CoinResponseBaseItem
import com.example.newcryptocurrencyapp.model.SingleCoinDetailsResponseBase

sealed class ApiState {
    object Loading : ApiState()
    class Failure(val msg:Throwable) : ApiState()
    class Success(val data:List<CoinResponseBaseItem>) : ApiState()
    object Empty : ApiState()
    class SuccessDetails(val data:SingleCoinDetailsResponseBase) : ApiState()
}


