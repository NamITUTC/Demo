package com.example.nam.demobasekotlin.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.nam.demobasekotlin.MainActivity
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.ui.menufind.MenuFragment
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({sends()},2000)
    }

    private fun sends() {

          startActivity(Intent(this,MainActivity::class.java))


        finish()
    }
}
