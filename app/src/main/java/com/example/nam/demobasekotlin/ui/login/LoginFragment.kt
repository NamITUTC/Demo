package com.example.nam.demobasekotlin.ui.login


import android.view.View
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.nam.demobasekotlin.App
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.common.CheckInput
import com.example.nam.demobasekotlin.common.Constant
import com.example.nam.demobasekotlin.common.Router
import com.example.nam.demobasekotlin.ui.register.User
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject


/**
 * Created by nam on 20/12/2017.
 */

class LoginFragment : BaseFragment(), View.OnClickListener, LoginView {


    @Inject
    lateinit var presenter: LoginPresenter
    @Inject
    lateinit var router: Router
    private lateinit var dialog: SweetAlertDialog

    private var email: String? = null
    private var pass: String? = null

    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
        return presenter as BasePresenter<T>
    }

    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_login
    }

    override fun initData() {
       dialog = SweetAlertDialog(activity, 1)
        dialog.titleText = "Oops.."
        dialog.confirmText = "Đóng"
        dialog.contentText = "Bạn phải xác nhận Email!"
               dialog .setConfirmClickListener { dialog.dismiss() }

    }

    override fun initView() {
        btnLogin.setOnClickListener(this)
        btnRegis.setOnClickListener(this)
        // onGetIntent()
    }
    override fun OnVerified(uid: String) {
        App.get().uId=uid
        router.goToMain()
    }
    private fun onGetIntent() {
        email = activity!!.intent.getStringExtra(Constant.KEY_EMAIL)
        pass = activity!!.intent.getStringExtra(Constant.KEY_PASS)
        edtLoginEmail.setText(email)
        edtLoginPass.setText(pass)
        var fromActivity = activity!!.intent.getStringExtra(Constant.KEY_FROM_ACTIVTY)
        fromActivity?.let {
            if (fromActivity == Constant.REGIS_ACTIVITY) {
                //   DialogUtils.showErorr(activity!!, Constant.REQUEST_CHECK_EMAIL)
            } else {
                Remember.isChecked = pass!!.isNotEmpty()
            }
        }

    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btnLogin -> loginAction()
            R.id.btnRegis -> router.getToRegister()
        }
    }

    private fun loginAction() {
        if (CheckInput.checkInPutLogin(edtLoginEmail,
                edtLoginPass, activity!!)) {
            //   dialogUtils.showLoading()
            email = edtLoginEmail.text.toString().trim()
            pass = edtLoginPass.text.toString().trim()
         /*   if (Remember.isChecked) {
                presenter.rememberUser(email!!, pass!!)


            } else {
                presenter.dismissUser()

            }*/
            presenter.onSignIn(email!!, pass!!)
        }
    }

    override fun onLoginFail(string: String) {
        //   dialogUtils.hideLoading()
        if (!activity!!.isFinishing) {
            //      DialogUtils.showErorr(activity!!, string)
        }
        dialog.contentText = "Tài Khoản chưa được đăng ký"
        dialog.show()

    }


    override fun onLoginSuccessfull() {
        presenter.checkEmailVerified()
      //  ToastUltil.show(activity!!, "success")


    }

    override fun onVerified(user: User?) {
        //
        //  dialogUtils.hideLoading()
     //   presenter.saveUser(user)


    }

    override fun onViriFail() {
        dialog.show()
    }


}