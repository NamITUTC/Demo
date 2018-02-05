package com.example.nam.demobasekotlin.ui.menufind.subfragment.place

import com.example.nam.demobasekotlin.base.BasePresenterImpl
import com.example.nam.demobasekotlin.models.map.Derection
import com.example.nam.demobasekotlin.models.map.Example
import com.example.nam.demobasekotlin.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by nam on 20/12/2017.
 */
class PlacePresenterImpl : PlacePresenter, BasePresenterImpl<PlaceView> {
    var apiService: ApiService

    @Inject constructor(apiService: ApiService) {
        this.apiService = apiService
    }

    override fun getAllPlace(currentLocation: String) {
        getDisposable()!!.add(
                apiService.getAllPlace(location = currentLocation)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())//{ result -> getView()!!.getAllPlaceSuccess(result) }
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ t -> getView()!!.getAllPlaceSuccess(result = t) },
                                { fail -> getView()!!.onFail(fail.message) }))
    }

    override fun getDistance(currentLocation: String, endLocation: String) {
        /*getDisposable()!!.add(
                apiService.getderection("Ha Noi city","Ho chi Minh city")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe{t-> getView()!!.OnSuccess(t)}
        )*/
        apiService.getderection(currentLocation, endLocation).enqueue(object : retrofit2.Callback<Derection> {
            override fun onFailure(call: Call<Derection>?, t: Throwable?) {
                getView()!!.onFail(t!!.message)
            }

            override fun onResponse(call: Call<Derection>?, response: Response<Derection>?) {
                getView()!!.OnSuccess(response!!.body())
            }

        })
    }
}