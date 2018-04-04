package com.example.nam.demobasekotlin.ui.register

import android.app.ProgressDialog
import android.view.View
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.Util.ToastUltil
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.common.CheckInput
import com.example.nam.demobasekotlin.common.Router
import kotlinx.android.synthetic.main.fragment_register.*
import javax.inject.Inject

/**
 * Created by MobileThanhNam on 4/4/2018.
 */
class RegisterFragment : BaseFragment(), View.OnClickListener, RegisterView {

    @Inject
    lateinit var presenter: RegisterPresenter
    private lateinit var email: String
    private lateinit var pass: String
    //private lateinit var dialogUtils: DialogUtils
    var dialog: ProgressDialog? = null
    @Inject
    lateinit var router: Router

    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
        return presenter as BasePresenter<T>
    }

    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_register
    }

    override fun initData() {

    }

    override fun initView() {
        btnSignUp.setOnClickListener {
            SignUpAction()
        }
        btnRegisBack.setOnClickListener {
            router.goToLogin()
        }
    }

    private fun SignUpAction() {
        if (CheckInput.checkInPutRegis(
                edtRegisEmail, edtRegisPass,
                edtConfirmPass, this!!.activity!!)) {
            //  dialogUtils.showLoading()
            email = edtRegisEmail.text.toString().trim()
            pass = edtRegisPass.text.toString().trim()
            presenter.onSignUp(email, pass)
        }
    }


    override fun onClick(view: View?) {
        when (view!!.id) {
        //   R.id.btn_login -> startActivity(Intent(activity, MenuFragment::class.java))
        }
    }

    override fun onRequestFailure(toString: String) {
        //    dialogUtils.hideLoading()
        /* if(String.equals(Contans.ERROR_ACOUNT_EXISTED)){
             DialogUtils.showErorr(this, Contans.ACOUNT_EXISTED)
         }else{
             DialogUtils.showErorr(this, string)
         }*/
        ToastUltil.show(activity!!, "fail" + toString)
    }

    override fun onSignUpSuccessful() {
        presenter.onCreatUserDatabase(email, "")
    }

    override fun onCreateUserSuccessful() {

        //   dialogUtils.hideLoading()
        ToastUltil.show(this.activity!!, "success")
        /*intent= Intent(this,LoginActivity::class.java)
        intent.putExtra(Contans.KEY_EMAIL,email)
        intent.putExtra(Contans.KEY_PASS,pass)
        intent.putExtra(Contans.KEY_FROM_ACTIVTY,Contans.REGIS_ACTIVITY)
        startActivity(intent)
        finish()*/
        router.goToLogin()
    }

}