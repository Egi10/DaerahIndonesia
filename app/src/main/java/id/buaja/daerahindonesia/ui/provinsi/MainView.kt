package id.buaja.daerahindonesia.ui.provinsi

import id.buaja.daerahindonesia.base.BaseView
import id.buaja.daerahindonesia.network.SemuaprovinsiItem

interface MainView : BaseView {
    fun onSuccess(list: List<SemuaprovinsiItem>?)
    fun onError(message: String?)
}