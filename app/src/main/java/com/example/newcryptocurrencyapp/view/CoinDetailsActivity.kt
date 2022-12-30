package com.example.newcryptocurrencyapp.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.newcryptocurrencyapp.R
import com.example.newcryptocurrencyapp.common.ApiState
import com.example.newcryptocurrencyapp.viewmodel.CoinDetailsViewModel
import com.example.newcryptocurrencyapp.viewmodel.CoinViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinDetailsActivity : AppCompatActivity() {
    private val coinDetailsViewModel: CoinDetailsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_details)
        var id= intent.extras?.getString("id")
        var type=intent.extras?.getString("type")
        Toast.makeText(this,"id is : "+
            id +" Name is : " +type,Toast.LENGTH_LONG).show()

        if (id != null) {
            coinDetailsViewModel.getCoinDetails(id)
        }
        lifecycleScope.launchWhenStarted{
            coinDetailsViewModel._coinStateFlow.collect { it ->

                when(it){
                    is ApiState.Loading->{

                    }
                    is ApiState.Failure -> {

                        Log.d("coinDetails", "onCreate: ${it.msg}")
                    }
                    is ApiState.SuccessDetails->{
                        Log.d("coinDetails", "onCreate: ${it.data.id}")
                        /*for (position in it.data){
                            Log.d("name", "onCreate: ${it.data}")
                        }*/
                        // coinAdapter.notifyDataSetChanged()
                    }
                    is ApiState.Empty->{
                        Log.d("coinDetails", "onCreate: ${it.toString()}")
                    }
                }


            }

        }

    }
}