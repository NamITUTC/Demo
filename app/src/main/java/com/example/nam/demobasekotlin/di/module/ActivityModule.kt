package com.example.nam.demobasekotlin.di.module

import com.example.nam.demobasekotlin.base.BaseActivity
import com.example.nam.demobasekotlin.ui.menu.MenuPresenter
import com.example.nam.demobasekotlin.ui.menu.MenuPresenterImpl
import com.example.nam.demobasekotlin.ui.menu.subfragment.Chat.ChatPresenter
import com.example.nam.demobasekotlin.ui.menu.subfragment.Chat.ChatPresenterImpl
import com.example.nam.demobasekotlin.ui.menu.subfragment.search.SearchPresenter
import com.example.nam.demobasekotlin.ui.menu.subfragment.search.SearchPresenterImpl
import com.example.nam.demobasekotlin.ui.menu.subfragment.view.ViewPresenter
import com.example.nam.demobasekotlin.ui.menu.subfragment.view.ViewPresenterImpl
import com.example.nam.demobasekotlin.ui.test.login.LoginPresenter
import com.example.nam.demobasekotlin.ui.test.login.LoginPresenterImpl
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

    @Provides
    fun bindMenuMainPresenter(presenter:com.example.nam.demobasekotlin.ui.menu.MenuPresenterImpl)
            :com.example.nam.demobasekotlin.ui.menu.MenuPresenter{
        return presenter
    }
    @Provides
    fun bindChatPresenter(presenter: ChatPresenterImpl): ChatPresenter {
        return presenter
    }
    @Provides
    fun bindSearchPresenter(presenter: SearchPresenterImpl): SearchPresenter {
        return presenter
    }
    @Provides
    fun bindViewPresenter(presenter: ViewPresenterImpl): ViewPresenter {
        return presenter
    }
    @Provides
    fun bindLogin(presenter:com.example.nam.demobasekotlin.ui.login2.LoginPresenterImpl):com.example.nam.demobasekotlin.ui.login2.LoginPresenter{
        return presenter
    }
}