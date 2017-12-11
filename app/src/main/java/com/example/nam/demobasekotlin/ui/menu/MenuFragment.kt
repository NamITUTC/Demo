package com.example.nam.demobasekotlin.ui.menu


import android.content.Intent
import android.os.Bundle
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.ui.activity.TestActivity
import com.example.nam.demobasekotlin.view.Constant
import com.example.nam.demobasekotlin.view.Router
import kotlinx.android.synthetic.main.fragment_menu.*
import javax.inject.Inject

/**
 * Created by nam on 11/12/2017.
 */
class MenuFragment : BaseFragment() {


    @Inject
    lateinit var menuPresenter:MenuPresenter

    @Inject
    lateinit var mRouter:Router

    override fun setText(s: Int) {

    }

    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_menu
    }

    override fun initData() {
/*
        var intent:Intent
        var bundle=intent.getBundleExtra(BaseSubActivity.EXTRA_FRAGMENT_ARGS)
        var hello= bundle.getString(Constant.HELLO)
        Toast.makeText(activity, hello,Toast.LENGTH_LONG).show()
*/
    }

    override fun initView() {
btn_open_activity.setOnClickListener {
    mRouter.goToTestActivity()
    var intent:Intent=Intent(activity,TestActivity::class.java)
    /*var bundle:Bundle= Bundle()
    bundle.putString("a","Nam")
    bundle.putString("b","Nguyen")

    intent.putExtra("bundle",bundle)
    */startActivity(intent)
}
    }

    override fun getPresenter(): BasePresenter<BaseView>? {
      return menuPresenter
    }

}