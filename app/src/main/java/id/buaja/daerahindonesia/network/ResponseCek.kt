package id.buaja.daerahindonesia.network

import com.google.gson.annotations.SerializedName

data class ResponseCek(

	@field:SerializedName("kabupatens")
	val kabupatens: List<KabupatensItem?>? = null,

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)