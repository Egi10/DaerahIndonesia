package id.buaja.daerahindonesia.network

import com.google.gson.annotations.SerializedName

data class KecamatansItem(

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("id_kabupaten")
	val idKabupaten: String? = null
)