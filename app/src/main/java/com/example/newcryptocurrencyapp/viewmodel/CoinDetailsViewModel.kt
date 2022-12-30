package com.example.newcryptocurrencyapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newcryptocurrencyapp.common.ApiState
import com.example.newcryptocurrencyapp.repository.CryptoCoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject
constructor(private val coinRepository: CryptoCoinRepository) : ViewModel()  {

    private val coinStateFlow: MutableStateFlow<ApiState>
            = MutableStateFlow(ApiState.Empty)

    val _coinStateFlow: StateFlow<ApiState> = coinStateFlow

    fun getCoinDetails(coinId : String) = viewModelScope.launch {

        coinStateFlow.value = ApiState.Loading
        coinRepository.getCoinDetailsData(coinId).catch { e->
            coinStateFlow.value=ApiState.Failure(e)
        }.collect { data->
            coinStateFlow.value=ApiState.SuccessDetails(data)
        }

    }
}