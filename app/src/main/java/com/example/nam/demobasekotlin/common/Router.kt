package com.example.nam.demobasekotlin.common

import android.os.Bundle
import com.example.nam.demobasekotlin.base.BaseActivity
import com.example.nam.demobasekotlin.base.BaseSubActivity
import com.example.nam.demobasekotlin.ui.chatboot.ChatBootFragment
import com.example.nam.demobasekotlin.ui.ibm.IBMFragment
import com.example.nam.demobasekotlin.ui.login.LoginFragment
import com.example.nam.demobasekotlin.ui.main.MainFragment
import com.example.nam.demobasekotlin.ui.main.healthtips.DetailHealthyTipsFragment
import com.example.nam.demobasekotlin.ui.main.healthtips.HealthTipsFragment
import com.example.nam.demobasekotlin.ui.main.pathological.PathologicalFragment
import com.example.nam.demobasekotlin.ui.main.pathologicalInfor.PathologicalInforFragment
import com.example.nam.demobasekotlin.ui.main.pathologicaldetail.PathologicalDetailFragment
import com.example.nam.demobasekotlin.ui.menufind.MenuFragment
import com.example.nam.demobasekotlin.ui.register.RegisterFragment
import javax.inject.Inject

/**
 * Created by ThanhNam on 2/4/2018.
 */
class Router @Inject constructor(private var activity: BaseActivity) {


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
        // start(PlaceFragment::class.java, bundle)
    }

    fun goToPathological() {
        start(PathologicalFragment::class.java)
    }

    fun goToChatBoot() {
        start(ChatBootFragment::class.java)
    }

    fun goToChatHealthyTip() {
        start(HealthTipsFragment::class.java)
    }

    fun goToMenu() {
        start(MenuFragment::class.java)
    }

    fun goToLogin() {
        start(LoginFragment::class.java)
    }

    fun getToRegister() {
        start(RegisterFragment::class.java)
    }

    fun goToMain() {
        start(MainFragment::class.java)
    }

    fun goIBM() {
        start(IBMFragment::class.java)
    }

    fun goToDetailHealthyTips(link: String) {
        var bundle = Bundle()
        bundle.putString(Constant.LINKHEALTHYTIPS, link)
        start(DetailHealthyTipsFragment::class.java, bundle)
    }

    fun goToPathologicalDetail(link: String) {
        var bundle = Bundle()
        bundle.putString(Constant.LINKDETAILPATHOLOGICAL, link)
        start(PathologicalDetailFragment::class.java, bundle)
    }

    fun goToPathologicalInfor(link: String) {
        var bundle = Bundle()
        bundle.putString(Constant.LINKINFORPATHOLOGICAL, link)
        start(PathologicalInforFragment::class.java, bundle)
    }


}