package com.example.nam.demobasekotlin.view

import android.os.Bundle
import com.example.nam.demobasekotlin.base.BaseActivity
import com.example.nam.demobasekotlin.base.BaseSubActivity
import com.example.nam.demobasekotlin.ui.menu.MenuFragment
import javax.inject.Inject

/**
 * Created by nam on 11/12/2017.
 */
class Router {
    private var activity: BaseActivity

    @Inject
    constructor(activity: BaseActivity) {
        this.activity = activity

    }

    fun goToMenu() {
        var bundle = Bundle()
        bundle.putString(Constant.HELLO, "hello")
        bundle.putString(Constant.HI, "hi")
        start(MenuFragment::class.java, bundle)
    }

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

}