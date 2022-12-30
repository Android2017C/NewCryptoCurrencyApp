package com.example.newcryptocurrencyapp.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newcryptocurrencyapp.R
import com.example.newcryptocurrencyapp.adapter.CoinDataAdapter
import com.example.newcryptocurrencyapp.common.ApiState
import com.example.newcryptocurrencyapp.databinding.ActivityMainBinding
import com.example.newcryptocurrencyapp.model.CoinResponseBaseItem
import com.example.newcryptocurrencyapp.viewmodel.CoinViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var coinAdapter: CoinDataAdapter
    private val coinViewModel:CoinViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerview()
        coinViewModel.getCoinList()
        lifecycleScope.launchWhenStarted{
            coinViewModel._coinStateFlow.collect{it ->
                when(it){
                    is ApiState.Loading->{
                        binding.recyclerview.isVisible=false
                        binding.progressBar.isVisible=true
                    }
                    is ApiState.Failure -> {
                        binding.recyclerview.isVisible = false
                        binding.progressBar.isVisible = false
                        Log.d("main", "onCreate: ${it.msg}")
                    }
                    is ApiState.Success->{
                        Log.d("main", "onCreate: ${it.data}")
                        /*for (position in it.data){
                            Log.d("name", "onCreate: ${it.data}")
                        }*/
                        binding.recyclerview.isVisible = true
                      binding.progressBar.isVisible = false
                       coinAdapter.setCoinsData(it.data)
                       // coinAdapter.notifyDataSetChanged()
                    }
                    is ApiState.Empty->{
                        Log.d("main", "onCreate: ${it.toString()}")
                    }
                }

            }


        }

    }

    private fun initRecyclerview() {
        coinAdapter= CoinDataAdapter(ArrayList())
        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@CoinMainActivity)
            adapter=coinAdapter
        }
    }
}