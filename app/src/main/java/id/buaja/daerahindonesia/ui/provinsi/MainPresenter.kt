package id.buaja.daerahindonesia.ui.provinsi

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import id.buaja.daerahindonesia.BuildConfig
import id.buaja.daerahindonesia.network.Response

class MainPresenter(private val view: MainView) {
    fun getSemuaProvinsi() {
        view.showLoading()
        AndroidNetworking.get("${BuildConfig.BASE_URL}daerahindonesia/provinsi")
            .setTag(this)
            .setPriority(Priority.LOW)
            .build()
            .getAsObject(Response::class.java, object : ParsedRequestListener<Response> {
                override fun onResponse(response: Response?) {
                    view.onSuccess(response?.semuaprovinsi)
                    view.hideLoading()
                }

                override fun onError(anError: ANError?) {
                    view.onError(anError?.message)
                    view.hideLoading()
                }
            })
    }
}