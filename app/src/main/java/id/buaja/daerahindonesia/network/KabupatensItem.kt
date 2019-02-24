package id.buaja.daerahindonesia.network

import com.google.gson.annotations.SerializedName

data class KabupatensItem(

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("id_prov")
	val idProv: String? = null
)