package id.buaja.daerahindonesia.ui.kecamatan

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import id.buaja.daerahindonesia.BuildConfig
import id.buaja.daerahindonesia.network.Response

class KecamatanPresenter(private val view: KecamatanView) {
    fun getKecamatan(idKabupaten: String?) {
        view.showLoading()
        AndroidNetworking.get("${BuildConfig.BASE_URL}provinsi/kabupaten/{id_kabupaten}/kecamatan")
            .addPathParameter("id_kabupaten", idKabupaten)
            .setTag(this)
            .setPriority(Priority.LOW)
            .build()
            .getAsObject(Response::class.java, object : ParsedRequestListener<Response> {
                override fun onResponse(response: Response?) {
                    view.onSuccess(response?.kecamatans)
                    view.hideLoading()
                }

                override fun onError(anError: ANError?) {
                    view.onError(anError?.message)
                    view.hideLoading()
                }
            })
    }
}