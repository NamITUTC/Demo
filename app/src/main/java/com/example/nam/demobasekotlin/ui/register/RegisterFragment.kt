package com.example.nam.demobasekotlin.ui.register

import android.app.ProgressDialog
import android.graphics.Color
import android.view.View
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.Util.ToastUltil
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.common.CheckInput
import com.example.nam.demobasekotlin.common.Router
import kotlinx.android.synthetic.main.fragment_register.*
import java.lang.Exception
import javax.inject.Inject

/**
 * Created by MobileThanhNam on 4/4/2018.
 */
class RegisterFragment : BaseFragment(), View.OnClickListener, RegisterView {
    override fun onCreateUserFail(e: Exception) {
        ToastUltil.show(activity!!,"Fail")
    }

    @Inject
    lateinit var presenter: RegisterPresenter
    private lateinit var email: String
    private lateinit var pass: String
    //private lateinit var dialogUtils: DialogUtils
    lateinit var dialog: SweetAlertDialog
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
        dialog = SweetAlertDialog(activity, 5)


        dialog.progressHelper.barColor = Color.parseColor("#A5DC86")
        dialog.titleText = "Loading"
        dialog.setCancelable(true)

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
            dialog.show()
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
        dialog.dismissWithAnimation()
        val  dialog = SweetAlertDialog(activity, 1)
        dialog.titleText = "Oops.."
        dialog.confirmText = "Đóng"
        dialog.contentText = "Đăng ký chưa hành công!"
        dialog .setConfirmClickListener {
            dialog.dismissWithAnimation()}
        dialog.show()

    }

    override fun onSignUpSuccessful() {
        presenter.onCreatUserDatabase(email, "")

    }

    override fun onCreateUserSuccessful() {

        //   dialogUtils.hideLoading()
     //   ToastUltil.show(this.activity!!, "success")
        /*intent= Intent(this,LoginActivity::class.java)
        intent.putExtra(Contans.KEY_EMAIL,email)
        intent.putExtra(Contans.KEY_PASS,pass)
        intent.putExtra(Contans.KEY_FROM_ACTIVTY,Contans.REGIS_ACTIVITY)
        startActivity(intent)
        finish()*/
        dialog.dismissWithAnimation()
      val  dialog = SweetAlertDialog(activity, 1)
        dialog.titleText = "Oops.."
        dialog.confirmText = "Đóng"
        dialog.contentText = "Bạn phải xác nhận Email để hoàn tất!"
        dialog .setConfirmClickListener {  router.goToLogin()
            dialog.dismissWithAnimation()}
        dialog.show()

    }

}