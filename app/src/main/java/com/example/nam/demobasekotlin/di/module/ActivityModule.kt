package com.example.nam.demobasekotlin.di.module

import com.example.nam.demobasekotlin.base.BaseActivity
import com.example.nam.demobasekotlin.ui.login.LoginPresenter
import com.example.nam.demobasekotlin.ui.login.LoginPresenterImpl
import com.example.nam.demobasekotlin.ui.menufind.subfragment.map.MapPresenter
import com.example.nam.demobasekotlin.ui.menufind.subfragment.map.MapPresenterImpl
import com.example.nam.demobasekotlin.ui.menufind.MenuPresenter
import com.example.nam.demobasekotlin.ui.menufind.MenuPresenterImpl
import com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat.ChatPresenter
import com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat.ChatPresenterImpl
import com.example.nam.demobasekotlin.ui.chatboot.ChatBootPresenter
import com.example.nam.demobasekotlin.ui.chatboot.ChatBootPresenterImpl
import com.example.nam.demobasekotlin.ui.main.MainPresenter
import com.example.nam.demobasekotlin.ui.main.MainPresenterImpl
import com.example.nam.demobasekotlin.ui.menufind.subfragment.view.ViewPresenter
import com.example.nam.demobasekotlin.ui.menufind.subfragment.view.ViewPresenterImpl
import dagger.Module
import dagger.Provides

/**
 * Created by nam on 08/12/2017.
 */
@Module
class ActivityModule(activity: BaseActivity) {

    private var activity: BaseActivity? = activity

    @Provides
    fun provideBaseActivity(): BaseActivity {
        return this.activity!!
    }


    @Provides
    fun sayHello(): String {
        return "Say hello"
    }

    @Provides
    fun bindMenuMainPresenter(presenter: MenuPresenterImpl): MenuPresenter {
        return presenter
    }

    @Provides
    fun bindChatPresenter(presenter: ChatPresenterImpl): ChatPresenter {
        return presenter
    }

    @Provides
    fun bindSearchPresenter(presenter: MainPresenterImpl): MainPresenter {
        return presenter
    }

    @Provides
    fun bindViewPresenter(presenter: ViewPresenterImpl): ViewPresenter {
        return presenter
    }

    @Provides
    fun bindLogin(presenter: LoginPresenterImpl): LoginPresenter {
        return presenter
    }

    @Provides
    fun bindChatBoot(presenter: ChatBootPresenterImpl): ChatBootPresenter {
        return presenter
    }

    @Provides
    fun bindMapPresenter(presenter: MapPresenterImpl): MapPresenter {
        return presenter
    }
}