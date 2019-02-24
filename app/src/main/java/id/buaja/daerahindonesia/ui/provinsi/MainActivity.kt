package id.buaja.daerahindonesia.ui.provinsi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.androidnetworking.AndroidNetworking
import id.buaja.daerahindonesia.R
import id.buaja.daerahindonesia.adapter.SemuaProvinsiAdapter
import id.buaja.daerahindonesia.network.SemuaprovinsiItem
import id.buaja.daerahindonesia.ui.kabupaten.KabupatenActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var mainPresenter: MainPresenter
    private lateinit var semuaProvinsiAdapter: SemuaProvinsiAdapter
    private var listSemuaProvinsi: MutableList<SemuaprovinsiItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AndroidNetworking.initialize(applicationContext)

        mainPresenter = MainPresenter(this)

        swipeRefresh.post {
            loadData()
        }

        swipeRefresh.setOnRefreshListener {
            loadData()
        }
    }

    private fun loadData() {
        mainPresenter.getSemuaProvinsi()

        semuaProvinsiAdapter = SemuaProvinsiAdapter(this, listSemuaProvinsi) {
            val intent = Intent(this, KabupatenActivity::class.java)
            intent.putExtra("id_provinsi", it.id)
            intent.putExtra("nama_provinsi", it.nama)
            startActivity(intent)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = semuaProvinsiAdapter
    }

    override fun onSuccess(list: List<SemuaprovinsiItem>?) {
        listSemuaProvinsi.clear()
        list?.let {
            listSemuaProvinsi.addAll(it)
        }
        semuaProvinsiAdapter.notifyDataSetChanged()
    }

    override fun onError(message: String?) {
        Log.d("MainActivity", message)
    }

    override fun showLoading() {
        swipeRefresh.isRefreshing = true
    }

    override fun hideLoading() {
        swipeRefresh.isRefreshing = false
    }
}
