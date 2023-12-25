package com.dicoding.rempahidonesiaku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.dicoding.rempahindonesia.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            goToMainActivity()
        },2500L)
    }
        private fun goToMainActivity (){
            Intent(this,MainActivity::class.java).also{
                startActivity(it)
                finish()
            }
        }
    }
