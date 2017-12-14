package com.example.nam.demobasekotlin.ui.menu

import android.util.Log
import com.example.nam.demobasekotlin.base.BasePresenterImpl
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.models.Data
import com.example.nam.demobasekotlin.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by nam on 11/12/2017.
 */
class MenuPresenterImpl() : MenuPresenter, BasePresenterImpl<BaseView>() {

    lateinit var apiService: ApiService

    @Inject
    constructor(apiService: ApiService) : this() {
        this.apiService = apiService
    }

    override fun getDataFromServer() {
        getDisposable()!!.add(
                apiService.getAllUser()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({data-> Log.d("erro", data.items!!.size.toString() ) })
                       /* .subscribe({ data-> Log.d("erro",data.toString())
                            getView()!!.LoadData(data) })*/
        )
        var data:MutableList<Data> = mutableListOf()
        getView()!!.LoadData(data)
    }

}