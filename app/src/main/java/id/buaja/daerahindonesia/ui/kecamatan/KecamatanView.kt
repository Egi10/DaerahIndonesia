package id.buaja.daerahindonesia.ui.kecamatan

import id.buaja.daerahindonesia.base.BaseView
import id.buaja.daerahindonesia.network.KecamatansItem

interface KecamatanView : BaseView {
    fun onSuccess(list: List<KecamatansItem>?)
    fun onError(message: String?)
}