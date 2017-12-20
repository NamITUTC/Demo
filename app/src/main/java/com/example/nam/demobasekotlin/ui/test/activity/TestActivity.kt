package com.example.nam.demobasekotlin.ui.test.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.nam.demobasekotlin.R

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
       /* var bundle=intent.getBundleExtra("bundle")
        var a=bundle.getString("a")
        var b=bundle.getString("b")
        Toast.makeText(this,a+b,Toast.LENGTH_LONG).show()*/
    }
}
