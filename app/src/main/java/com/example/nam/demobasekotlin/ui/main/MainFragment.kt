package com.example.nam.demobasekotlin.ui.main

import android.content.Intent
import android.view.View
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.common.Router
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

/**
 * Created by nam on 20/12/2017.
 */
class MainFragment : BaseFragment(), View.OnClickListener {
    @Inject
    lateinit var presenter: MainPresenter
    @Inject
    lateinit var router: Router

    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_main
    }

    override fun initData() {

    }

    override fun initView() {
        btn_diseases.setOnClickListener(this)
        btn_menu.setOnClickListener(this)
        btn_healthy_tip.setOnClickListener(this)
        btn_tf.setOnClickListener(this)
        btn_chat_bot.setOnClickListener(this)
    }

    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
        return presenter as BasePresenter<T>
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btn_diseases -> router.goToPathological()
            R.id.btn_chat_bot -> router.goToChatBoot()
            R.id.btn_menu -> router.goToMenu()
            R.id.btn_healthy_tip -> router.goToChatHealthyTip()
            R.id.btn_tf ->  router.goIBM()
        }
    }


    private fun loadFragment(fragment: BaseFragment) {
        router.goToPathological()
    }


}