package id.buaja.daerahindonesia.network

import com.google.gson.annotations.SerializedName

data class SemuaprovinsiItem(

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)