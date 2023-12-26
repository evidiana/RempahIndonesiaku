package com.dicoding.rempahidonesiaku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.rempahindonesiaku.R

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val list = ArrayList<Rempah> ()
    private lateinit var rvRempahs: RecyclerView
    private fun showSelectedRempah(rempah: Rempah) {
        Toast.makeText(this, "Kamu memilih " + rempah.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvRempahs = findViewById(R.id.rv_rempahs)
        rvRempahs.setHasFixedSize(true)
        list.addAll(getListRempahs())
        showRecyclerList()

        val mPage: Button = findViewById(R.id.aboutMe)
        mPage.setOnClickListener(this)
    }
        private fun getListRempahs(): ArrayList<Rempah> {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
            val tvDetailName = resources.getStringArray(R.array.tv_detail_name)
            val tvDetailDescription = resources.getStringArray(R.array.tv_detail_description)
            val tvDetailPhoto = resources.obtainTypedArray(R.array.tv_detail_photo)
            val listRempah = ArrayList<Rempah>()
            for (i in dataName.indices) {
                val rempah = Rempah(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1),
                    tvDetailName[i], tvDetailDescription[i], tvDetailPhoto.getResourceId(i, -1) )
                listRempah.add(rempah)
            }
            return listRempah
        }

        private fun showRecyclerList() {
            rvRempahs.layoutManager = LinearLayoutManager(this)
            val listRempahAdapter = ListRempahAdapter(list)
            rvRempahs.adapter = listRempahAdapter

            listRempahAdapter.setOnItemClickCallback(object : ListRempahAdapter.OnItemClickCallback {
                override fun onItemClicked(data: Rempah) {
                    showSelectedRempah(data)
                }
            })
        }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.aboutMe -> {
                val moveIntent = Intent(this@MainActivity, AboutPage::class.java)
                startActivity(moveIntent)
            }
        }
    }
}

