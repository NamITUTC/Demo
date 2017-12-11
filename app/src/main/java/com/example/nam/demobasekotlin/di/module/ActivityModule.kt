package com.example.nam.demobasekotlin.di.module

import com.example.nam.demobasekotlin.base.BaseActivity
import com.example.nam.demobasekotlin.ui.login.LoginPresenter
import com.example.nam.demobasekotlin.ui.login.LoginPresenterImpl
import com.example.nam.demobasekotlin.ui.menu.MenuPresenter
import com.example.nam.demobasekotlin.ui.menu.MenuPresenterImpl
import dagger.Module
import dagger.Provides

/**
 * Created by nam on 08/12/2017.
 */
@Module
class ActivityModule{

    private var activity: BaseActivity? = null

   constructor (activity: BaseActivity) {
        this.activity = activity
    }

    @Provides
    fun provideBaseActivity(): BaseActivity {
        return this!!.activity!!
    }
    @Provides
    fun bindLoginPresenter(presenter: LoginPresenterImpl): LoginPresenter {
        return presenter
    }

    @Provides
    fun bindMenuPresenter(presenter: MenuPresenterImpl) :MenuPresenter{
        return presenter
    }

    @Provides
    fun sayHello():String{
        return "Say hello"
    }
}