package com.example.nam.demobasekotlin.ui.login

import android.content.Intent
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.view.Router
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

/**
 * Created by nam on 08/12/2017.
 */
class LoginFragment : BaseFragment() {
    override fun setText(s: Int) {
        txt_test.text=s.toString()
    }


    @Inject
    lateinit var mRouter:Router
    @Inject
    lateinit var ff: LoginPresenter

    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {

            return R.layout.fragment_login
    }

    override fun initData() {
        ff.show(5,6)
    }

    override fun initView() {
        btn_chuyen.setOnClickListener {
            ff.next()
            //var intent=Intent()
            //intent.setAction("MyBroadcast")
            //intent.putExtra("value",1000)

           // sendBroadcast(intent)
            mRouter.goToMenu()
        }
    }


    override fun getPresenter(): BasePresenter<BaseView> {
        return ff
    }

}