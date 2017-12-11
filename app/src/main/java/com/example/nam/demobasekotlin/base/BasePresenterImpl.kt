package com.example.nam.demobasekotlin.base

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by nam on 08/12/2017.
 */
open class BasePresenterImpl<T : BaseView> : BasePresenter<T> {
    private var view: T? = null
    private var disposable: CompositeDisposable? = null

    override fun onAttachView(view: T) {
        this.view = view
        disposable = CompositeDisposable()
    }

    override fun onDetach() {
        view = null
        disposable!!.dispose()
    }

    fun getView(): T? {
        return view
    }

    fun getDisposable(): CompositeDisposable? {
        return disposable
    }
}