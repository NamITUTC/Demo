package com.example.nam.demobasekotlin.ui.login


import android.content.Intent
import android.view.View
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject


/**
 * Created by nam on 20/12/2017.
 */

class LoginFragment : BaseFragment(), View.OnClickListener {
    @Inject
    lateinit var presenter: LoginPresenter
    var callbackManager = CallbackManager.Factory.create()
    private var mAuth = FirebaseAuth.getInstance()


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
       // btn_login.setOnClickListener(this)
    }

    override fun initView() {
        callbackManager = CallbackManager.Factory.create()

        LoginManager.getInstance().registerCallback(callbackManager,
                object : FacebookCallback<LoginResult> {
                    override fun onSuccess(loginResult: LoginResult) {

                        handleFacebookAccessToken(loginResult.getAccessToken())

                    }

                    override fun onCancel() {

                    }

                    override fun onError(exception: FacebookException) {

                    }
                })
    }

    private fun handleFacebookAccessToken(token: AccessToken?) {
        val credential = FacebookAuthProvider.getCredential(token!!.getToken())

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
         //   R.id.btn_login -> startActivity(Intent(activity, MenuFragment::class.java))
        }
    }
}