package id.buaja.daerahindonesia.network

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("semuaprovinsi")
	val semuaprovinsi: List<SemuaprovinsiItem>? = null,

	@field:SerializedName("kabupatens")
	val kabupatens: List<KabupatensItem>? = null,

	@field:SerializedName("kecamatans")
	val kecamatans: List<KecamatansItem>? = null
)