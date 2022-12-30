package com.example.newcryptocurrencyapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.newcryptocurrencyapp.databinding.CoinRowItemBinding
import com.example.newcryptocurrencyapp.model.CoinResponseBaseItem
import com.example.newcryptocurrencyapp.view.CoinDetailsActivity

class CoinDataAdapter(private var coinsList: List<CoinResponseBaseItem>) :
    RecyclerView.Adapter<CoinDataAdapter.CoinViewHolder>() {

    private lateinit var binding: CoinRowItemBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        binding = CoinRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        var coinData = coinsList[position]
        holder.bind(coinData = coinData)
        var coinDatass = coinsList[position].type
        binding.typeTxt.setOnClickListener {
            var intent = Intent(it.context, CoinDetailsActivity::class.java)
            intent.putExtra("id", coinData.id)
            intent.putExtra("type", coinData.type)
            it.context.startActivity(intent)

            val position = binding.typeTxt
            Toast.makeText(
                it.context,
                "clicked type is : " + coinDatass.toString(),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun getItemCount(): Int {
        return coinsList.size
    }

    fun setCoinsData(coinsListData: List<CoinResponseBaseItem>) {
        this.coinsList = coinsListData
        notifyDataSetChanged()
    }

    class CoinViewHolder(private val binding: CoinRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(coinData: CoinResponseBaseItem) {
            binding.coins = coinData
        }
    }


}