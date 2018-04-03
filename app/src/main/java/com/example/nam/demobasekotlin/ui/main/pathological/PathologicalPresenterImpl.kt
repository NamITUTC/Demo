package com.example.nam.demobasekotlin.ui.main.pathological

import com.example.nam.demobasekotlin.base.BasePresenterImpl
import com.example.nam.demobasekotlin.network.ApiClient
import com.example.nam.demobasekotlin.ui.main.ApiServiceMain
import com.ominext.namnt.demorequestapiapplication.model.Pathological
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by ThanhNam on 1/30/2018.
 */
class PathologicalPresenterImpl @Inject constructor() : PathologicalPresenter, BasePresenterImpl<PathologicalView>() {
    override fun getAllPathological() {
        ApiClient.getInstance()!!.create(ApiServiceMain::class.java).getAllPathological().enqueue(object : Callback<MutableList<Pathological>> {
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