package com.example.nam.demobasekotlin.ui.main

import android.view.View
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.ui.chatboot.ChatBootFragment
import com.example.nam.demobasekotlin.ui.menufind.MenuFragment
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

/**
 * Created by nam on 20/12/2017.
 */
class MainFragment : BaseFragment(), View.OnClickListener {
       @Inject
    lateinit var presenter: MainPresenter
   /* @BindView(R.id.btn_diseases)
    lateinit var  btnDiseases :CardView
    @BindView(R.id.btn_2)
    lateinit var btn2:CardView
    @BindView(R.id.btn_3)
    lateinit var btn3:CardView
    @BindView(R.id.btn_4)
    lateinit var btn4:CardView
    @BindView(R.id.btn_chat_bot)
    lateinit var btnChatBot:CardView*/
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
        btn_2.setOnClickListener(this)
        btn_3.setOnClickListener(this)
        btn_4.setOnClickListener(this)
        btn_chat_bot.setOnClickListener(this)
    }

    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
        return presenter as BasePresenter<T>
    }
    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.btn_diseases->loadFragment(ChatBootFragment())
            R.id.btn_chat_bot->loadFragment(ChatBootFragment())
            R.id.btn_2->loadFragment(ChatBootFragment())
            R.id.btn_3->loadFragment(MenuFragment())
            R.id.btn_4->loadFragment(ChatBootFragment())
        }
    }

    private fun loadFragment(fragment: BaseFragment) {

    }


}