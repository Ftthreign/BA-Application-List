package com.example.ba_application_list.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.ba_application_list.MainActivity
import com.example.ba_application_list.R

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private fun goToMainActivity() {
        val intentMain = Intent(this, MainActivity::class.java)
        startActivity(intentMain)
        finish()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({
            goToMainActivity()
        },1000L)
    }
}