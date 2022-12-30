package com.example.newcryptocurrencyapp.model

import com.google.gson.annotations.SerializedName

data class CoinResponseBase(

	@field:SerializedName("CoinResponseBase")
	val coinResponseBase: List<CoinResponseBaseItem?>? = null
)

data class CoinResponseBaseItem(

	@field:SerializedName("symbol")
	val symbol: String? = null,

	@field:SerializedName("is_active")
	val isActive: Boolean? = null,

	@field:SerializedName("is_new")
	val isNew: Boolean? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("rank")
	val rank: Int? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)
