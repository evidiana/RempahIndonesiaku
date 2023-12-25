package com.dicoding.rempahidonesiaku

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.rempahindonesia.R

class DetailRempah : AppCompatActivity() {
    lateinit var mShare : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_rempah)

        mShare  = findViewById<Button>(R.id.btnShare)
        mShare.setOnClickListener{
            val myIntent = Intent(Intent.ACTION_SEND)
            myIntent.type = "type/plain"
            val shareBody = "You are body"
            val shareSub = "You subject here"
            myIntent.putExtra(Intent.EXTRA_SUBJECT , shareBody)
            myIntent.putExtra(Intent.EXTRA_TEXT , shareSub)
            startActivity(Intent.createChooser(myIntent, "Share your App"))
        }

        val dataRempah = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Rempah>("key_rempah", Rempah::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Rempah>("key_rempah")
        }
        val tvDetailName = findViewById<TextView>(R.id.tv_detail_name)
        val tvDetailDescription = findViewById<TextView>(R.id.tv_detail_description)
        val tvDetailPhoto = findViewById<ImageView>(R.id.img_detail_photo)

        tvDetailName.text = dataRempah?.name
        tvDetailDescription.text = dataRempah?.description
        tvDetailPhoto.setImageResource(dataRempah?.photo!!)


    } }



