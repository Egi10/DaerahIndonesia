package id.buaja.daerahindonesia.ui.kabupaten

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.androidnetworking.AndroidNetworking
import id.buaja.daerahindonesia.R
import id.buaja.daerahindonesia.adapter.KabupatenAdapter
import id.buaja.daerahindonesia.network.KabupatensItem
import id.buaja.daerahindonesia.ui.kecamatan.KecamatanActivity
import kotlinx.android.synthetic.main.activity_kabupaten.*

class KabupatenActivity : AppCompatActivity(), KabupatenView {
    private lateinit var kabupatenPresenter: KabupatenPresenter
    private var idProvinsi: String = ""
    private var listKabupaten: MutableList<KabupatensItem> = mutableListOf()
    private lateinit var kabupatenAdapter: KabupatenAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kabupaten)
        title = intent.getStringExtra("nama_provinsi")

        AndroidNetworking.initialize(applicationContext)

        idProvinsi = intent.getStringExtra("id_provinsi")
        Log.d("idProvinsi", idProvinsi)

        kabupatenPresenter = KabupatenPresenter(this)

        swipeRefresh.post {
            loadData(idProvinsi)
        }

        swipeRefresh.setOnRefreshListener {
            loadData(idProvinsi)
        }
    }

    private fun loadData(idProvinsi: String) {
        kabupatenPresenter.getKabupaten(idProvinsi)

        kabupatenAdapter = KabupatenAdapter(this, listKabupaten) {
            val intent = Intent(this, KecamatanActivity::class.java)
            intent.putExtra("id_kabupaten", it.id)
            intent.putExtra("nama_kabupaten", it.nama)
            startActivity(intent)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = kabupatenAdapter
    }

    override fun onSuccess(list: List<KabupatensItem>?) {
        Log.d("Kabupaten", list?.size.toString())

        listKabupaten.clear()
        list?.let {
            listKabupaten.addAll(it)
        }
        kabupatenAdapter.notifyDataSetChanged()
    }

    override fun onError(message: String?) {
        Log.d("Kabupaten", message.toString())
    }

    override fun showLoading() {
        swipeRefresh.isRefreshing = true
    }

    override fun hideLoading() {
        swipeRefresh.isRefreshing = false
    }
}
