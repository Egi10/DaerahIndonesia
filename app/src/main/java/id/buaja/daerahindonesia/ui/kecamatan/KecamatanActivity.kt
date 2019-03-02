package id.buaja.daerahindonesia.ui.kecamatan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.androidnetworking.AndroidNetworking
import id.buaja.daerahindonesia.R
import id.buaja.daerahindonesia.adapter.KecamatanAdapter
import id.buaja.daerahindonesia.network.KecamatansItem
import kotlinx.android.synthetic.main.activity_kecamatan.*

class KecamatanActivity : AppCompatActivity(), KecamatanView {
    private lateinit var kecamatanPresenter: KecamatanPresenter
    private lateinit var adapterKecamatan: KecamatanAdapter
    private var listKecamatan: MutableList<KecamatansItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kecamatan)

        AndroidNetworking.initialize(this)

        kecamatanPresenter = KecamatanPresenter(this)

        val idKabupaten = intent.getStringExtra("id_kabupaten")
        val namaKabupaten = intent.getStringExtra("nama_kabupaten")
        title = namaKabupaten

        swipeRefresh.post {
            loadData(idKabupaten)
        }

        swipeRefresh.setOnRefreshListener {
            loadData(idKabupaten)
        }
    }

    private fun loadData(idKabupaten: String?) {
        kecamatanPresenter.getKecamatan(idKabupaten)

        adapterKecamatan = KecamatanAdapter(this, listKecamatan) {

        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapterKecamatan
    }

    override fun onSuccess(list: List<KecamatansItem>?) {
        Log.d("Success", list?.size.toString())

        listKecamatan.clear()
        list?.let {
            listKecamatan.addAll(it)
        }
        adapterKecamatan.notifyDataSetChanged()
    }

    override fun onError(message: String?) {
        Log.d("Error", message)
    }

    override fun showLoading() {
        swipeRefresh.isRefreshing = true
    }

    override fun hideLoading() {
        swipeRefresh.isRefreshing = false
    }
}
