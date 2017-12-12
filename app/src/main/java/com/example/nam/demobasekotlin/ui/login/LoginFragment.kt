package com.example.nam.demobasekotlin.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.models.Note
import com.example.nam.demobasekotlin.view.Constant
import com.example.nam.demobasekotlin.view.Router
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

/**
 * Created by nam on 08/12/2017.
 */
class LoginFragment : BaseFragment(), View.OnClickListener {


    @Inject
    lateinit var mRouter: Router
    @Inject
    lateinit var presenter: LoginPresenter

    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {

        return R.layout.fragment_login
    }

    override fun initData() {
        presenter.show(5, 6)
    }

    override fun initView() {
        btn_chuyen.setOnClickListener {
            presenter.next()
            activity.intent.getBundleExtra(Constant.HELLO)
            //var intent=Intent()
            //intent.setAction("MyBroadcast")
            //intent.putExtra("value",1000)

            // sendBroadcast(intent)
            var bundle: Bundle = Bundle()
            bundle.putString("a", "Nam")
            bundle.putString("b", "Nguyen")

            //intent.putExtra("bundle",bundle)
            mRouter.goToMenu()
            var ss: String? = null
            if (ss != null) {
                Toast.makeText(activity, ss!!, Toast.LENGTH_LONG).show()
            }

        }
        btn_add.setOnClickListener(this)
        btn_view.setOnClickListener(this)
    }


    override fun getPresenter(): BasePresenter<BaseView> {
        return presenter
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btn_add -> presenter.addNote(Note(4, "aaaaa", "baaaa"))
            R.id.btn_view -> presenter.viewNote()
        }
    }

    override fun setText(s: Int) {
        txt_test.text = s.toString()
    }

}