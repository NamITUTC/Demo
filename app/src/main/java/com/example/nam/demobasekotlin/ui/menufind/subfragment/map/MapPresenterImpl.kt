package com.example.nam.demobasekotlin.ui.menufind.subfragment.map

import com.example.nam.demobasekotlin.base.BasePresenterImpl
import com.example.nam.demobasekotlin.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by ThanhNam on 1/7/2018.
 */
class MapPresenterImpl : MapPresenter, BasePresenterImpl<MapsView> {

    private var apiService: ApiService

    @Inject constructor(apiService: ApiService) {
        this.apiService = apiService
    }

    override fun callApi(location: String) {
        getDisposable()!!.add(
                apiService.getAllPlace(location)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe ({ t -> getView()!!.onSuccess(t) },
                                { fail -> getView()!!.onFail(fail.message!!) })
        )
    }
}