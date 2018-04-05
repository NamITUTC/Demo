package com.example.nam.demobasekotlin.ui.main.healthtips

import com.example.nam.demobasekotlin.base.BasePresenterImpl
import com.example.nam.demobasekotlin.network.ApiClient
import com.example.nam.demobasekotlin.network.ApiService
import com.example.nam.demobasekotlin.ui.main.ApiServiceMain
import com.ominext.namnt.demorequestapiapplication.model.HealthTip
import com.squareup.okhttp.Call
import com.squareup.okhttp.Callback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by ThanhNam on 1/30/2018.
 */
class HealthTipsPresenterImpl : HealthTipsPresenter, BasePresenterImpl<HealthTipsView> {

    private var mApiService: ApiService

    @Inject constructor(apiService: ApiService) {
        this.mApiService = apiService
    }

    override fun getAllHealthTips() {
        ApiClient.getInstance()!!.create(ApiServiceMain::class.java)
                .getAllHealthTips().enqueue(object : retrofit2.Callback<MutableList<HealthTip>> {
            override fun onFailure(call: retrofit2.Call<MutableList<HealthTip>>?, t: Throwable?) {
                if (t != null) {
                    getView()!!.onFail(t.message!!)
                }
            }

            override fun onResponse(call: retrofit2.Call<MutableList<HealthTip>>?, response: Response<MutableList<HealthTip>>?) {
                if (response!!.isSuccessful) {
                    getView()!!.onSuccess(response.body())
                }
            }
        })
        /* .getAllHealthTips().subscribeOn(Schedulers.io())
         .observeOn(AndroidSchedulers.mainThread())
         .subscribe({ data -> getView()!!.onSuccess(data) },
                 { fail -> getView()!!.onFail(fail.toString()) })*/
    }

}