package id.buaja.daerahindonesia.ui.kabupaten

import id.buaja.daerahindonesia.base.BaseView
import id.buaja.daerahindonesia.network.KabupatensItem

interface KabupatenView : BaseView {
    fun onSuccess(list: List<KabupatensItem>?)
    fun onError(message: String?)
}