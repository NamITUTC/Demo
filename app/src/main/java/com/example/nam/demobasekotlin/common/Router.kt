package com.example.nam.demobasekotlin.common

import android.os.Bundle
import com.example.nam.demobasekotlin.base.BaseActivity
import com.example.nam.demobasekotlin.base.BaseSubActivity
import com.example.nam.demobasekotlin.ui.menufind.subfragment.place.PlaceFragment
import javax.inject.Inject

/**
 * Created by ThanhNam on 2/4/2018.
 */
class Router @Inject constructor(private var activity: BaseActivity) {

    /* fun goToMenu() {

    }*/

    private fun start(classOf: Class<*>) {
        val intent = BaseSubActivity.createIntent(activity)
        intent.putExtra(BaseSubActivity.EXTRA_FRAGMENT_CLASS, classOf)
        BaseSubActivity.start(activity, intent)
    }

    private fun start(classOf: Class<*>, bundle: Bundle) {
        val intent = BaseSubActivity.createIntent(activity)
        intent.putExtra(BaseSubActivity.EXTRA_FRAGMENT_CLASS, classOf)
        intent.putExtra(BaseSubActivity.EXTRA_FRAGMENT_ARGS, bundle)
        BaseSubActivity.start(activity, intent)
    }

    private fun startFoResult(classOf: Class<*>, requestCode: Int) {
        val intent = BaseSubActivity.createIntent(activity)
        intent.putExtra(BaseSubActivity.EXTRA_FRAGMENT_CLASS, classOf)
        BaseSubActivity.startForResult(activity, intent, requestCode)
    }

    private fun startFoResult(classOf: Class<*>, bundle: Bundle, requestCode: Int) {
        val intent = BaseSubActivity.createIntent(activity)
        intent.putExtra(BaseSubActivity.EXTRA_FRAGMENT_CLASS, classOf)
        intent.putExtra(BaseSubActivity.EXTRA_FRAGMENT_ARGS, bundle)
        BaseSubActivity.startForResult(activity, intent, requestCode)
    }

    fun goToTestActivity() {

    }

    fun sendToPlaceFragment(location: String) {
        var bundle = Bundle()
        bundle.putString(Constant.HELLO, location)
        start(PlaceFragment::class.java, bundle)
    }
}