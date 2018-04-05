package com.example.nam.demobasekotlin.ui.main.pathologicaldetail

import com.example.nam.demobasekotlin.base.BasePresenterImpl
import com.example.nam.demobasekotlin.network.ApiClient
import com.example.nam.demobasekotlin.ui.main.ApiServiceMain
import com.ominext.namnt.demorequestapiapplication.model.Pathological
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by MobileThanhNam on 4/5/2018.
 */
class PathologicalDetailImpl @Inject constructor() : BasePresenterImpl<PathologicalDetailView>(), PathologicalDetailPresenter {
    override fun getAllPathological(url: String) {
        ApiClient.getInstance()!!.create(ApiServiceMain::class.java).getDetailPathological(url).enqueue(object : Callback<MutableList<Pathological>> {
            override fun onFailure(call: Call<MutableList<Pathological>>?, t: Throwable?) {
                getView()!!.onFail(t!!.message)
            }

            override fun onResponse(call: Call<MutableList<Pathological>>?, response: Response<MutableList<Pathological>>?) {
                if(response!!.isSuccessful){
                    getView()!!.onSuccess(response.body())
                }

            }
        })
    }

}