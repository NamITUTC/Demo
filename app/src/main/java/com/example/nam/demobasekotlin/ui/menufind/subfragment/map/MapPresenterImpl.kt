package com.example.nam.demobasekotlin.ui.menufind.subfragment.map

import com.example.nam.demobasekotlin.base.BasePresenterImpl
import com.example.nam.demobasekotlin.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import javax.inject.Inject

/**
 * Created by ThanhNam on 1/7/2018.
 */
class MapPresenterImpl : MapPresenter, BasePresenterImpl<MapsView> {

    var apiService: ApiService

    @Inject constructor(apiService: ApiService) {
        this.apiService = apiService
    }

    override fun callApi() {
        getDisposable()!!.add(
                apiService.getAllPlace()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe{t-> getView()!!.onSuccess("") } /*{
                            object : Subscriber<ResponseBody> {
                                override fun onComplete() {

                                }

                                override fun onSubscribe(s: Subscription?) {
                                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                }

                                override fun onNext(t: ResponseBody?) {
                                    getView()!!.onSuccess(t!!.string())

                                }

                                override fun onError(t: Throwable?) {

                                }
                            }
                        }*/
        )
    }
}