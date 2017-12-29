package com.example.nam.demobasekotlin.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.nam.demobasekotlin.App
import com.example.nam.demobasekotlin.R

/**
 * Created by nam on 08/12/2017.
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract fun initFragment(): BaseFragment?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        replaceFragment(initFragment())
    }

    private fun replaceFragment(fragment: BaseFragment?) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit()
        }
    }

    override fun onResume() {
        super.onResume()
        App.get().setCurrentActivity(this)
    }
}