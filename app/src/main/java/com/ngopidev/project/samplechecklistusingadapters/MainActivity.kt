package com.ngopidev.project.samplechecklistusingadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ngopidev.project.samplechecklistusingadapters.helpers.AdapterHelpers
import com.ngopidev.project.samplechecklistusingadapters.helpers.SampleData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterHelpers.funcData {

    val dataAll = ArrayList<SampleData>()
    lateinit var adapters : AdapterHelpers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        dataAll.add(SampleData("sumantri", "Jakarta", false))
        dataAll.add(SampleData("wijaya", "Sumedang", false))
        dataAll.add(SampleData("kusuma", "Makassar", false))
        dataAll.add(SampleData("bambang", "Surabaya", false))
        dataAll.add(SampleData("trinurdianto", "Lembang", false))

        adapters = AdapterHelpers(this, dataAll, this)
        rcView.layoutManager = LinearLayoutManager(this)
        rcView.adapter = adapters

    }

    override fun addData(
        viewHolder: AdapterHelpers.HelpersViewHolder,
        sampleData: SampleData,
        position: Int
    ) {
        val name = dataAll.get(viewHolder.adapterPosition).nama
        Toast.makeText(this@MainActivity, "user ${name} berhasil ditambahkan", Toast.LENGTH_SHORT).show()
    }

    override fun delData(
        viewHolder: AdapterHelpers.HelpersViewHolder,
        sampleData: SampleData,
        position: Int
    ) {
        val name = dataAll.get(viewHolder.adapterPosition).nama
        Toast.makeText(this@MainActivity, "user ${name} berhasil dikeluarkan", Toast.LENGTH_SHORT).show()

    }
}
