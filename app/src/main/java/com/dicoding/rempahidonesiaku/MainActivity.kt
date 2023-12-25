package com.dicoding.rempahidonesiaku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.rempahindonesia.R

class MainActivity : AppCompatActivity() {

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
    }
        private fun getListRempahs(): ArrayList<Rempah> {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
            val listRempah = ArrayList<Rempah>()
            for (i in dataName.indices) {
                val rempah = Rempah(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvRempahs.layoutManager = LinearLayoutManager(this)
            }
        }
        return super.onOptionsItemSelected(item)
    } }
