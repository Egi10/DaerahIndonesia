package id.buaja.daerahindonesia.ui.kabupaten

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import id.buaja.daerahindonesia.BuildConfig
import id.buaja.daerahindonesia.network.Response

class KabupatenPresenter(private val view: KabupatenView) {
    fun getKabupaten(idProvinsi: String?) {
        view.showLoading()
        AndroidNetworking.get("${BuildConfig.BASE_URL}provinsi/{id_provinsi}/kabupaten")
            .addPathParameter("id_provinsi", idProvinsi)
            .setTag(this)
            .setPriority(Priority.LOW)
            .build()
            .getAsObject(Response::class.java, object : ParsedRequestListener<Response> {
                override fun onResponse(response: Response?) {
                    view.onSuccess(response?.kabupatens)
                    view.hideLoading()
                }

                override fun onError(anError: ANError?) {
                    view.onError(anError?.message)
                    view.hideLoading()
                }
            })
    }
}