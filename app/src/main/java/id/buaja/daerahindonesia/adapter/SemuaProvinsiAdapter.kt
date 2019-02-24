package id.buaja.daerahindonesia.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.buaja.daerahindonesia.R
import id.buaja.daerahindonesia.network.SemuaprovinsiItem
import kotlinx.android.synthetic.main.layout_list_semua_provinsi.view.*

class SemuaProvinsiAdapter(private val context: Context, private val list: List<SemuaprovinsiItem>, private val listener: (SemuaprovinsiItem) -> Unit)
    : RecyclerView.Adapter<SemuaProvinsiAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
        SemuaProvinsiAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_list_semua_provinsi, p0, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindItem(list[p1], listener, p1)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(semuaprovinsiItem: SemuaprovinsiItem, listener: (SemuaprovinsiItem) -> Unit, position: Int) {
            var noUrut: Int = 0
            for (i in 0..position) {
                noUrut = i + 1
            }
            itemView.tvNoUrut.text = noUrut.toString()
            itemView.tvNamaProvinsi.text = semuaprovinsiItem.nama
            itemView.setOnClickListener {
                listener(semuaprovinsiItem)
            }
        }
    }
}