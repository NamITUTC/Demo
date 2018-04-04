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
import com.example.nam.demobasekotlin.ui.ibm.IBMFragment
import com.example.nam.demobasekotlin.ui.ibm.IBMPresenter
import com.example.nam.demobasekotlin.ui.ibm.IBMPresenterImpl
import com.example.nam.demobasekotlin.ui.main.MainPresenter
import com.example.nam.demobasekotlin.ui.main.MainPresenterImpl
import com.example.nam.demobasekotlin.ui.main.healthtips.HealthTipsPresenter
import com.example.nam.demobasekotlin.ui.main.healthtips.HealthTipsPresenterImpl
import com.example.nam.demobasekotlin.ui.main.pathological.PathologicalPresenter
import com.example.nam.demobasekotlin.ui.main.pathological.PathologicalPresenterImpl
import com.example.nam.demobasekotlin.ui.menufind.subfragment.place.PlacePresenter
import com.example.nam.demobasekotlin.ui.menufind.subfragment.place.PlacePresenterImpl
import com.example.nam.demobasekotlin.ui.register.RegisterPresenter
import com.example.nam.demobasekotlin.ui.register.RegisterPresenterImpl
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
    fun bindViewPresenter(presenter: PlacePresenterImpl): PlacePresenter {
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

    @Provides
    fun bindHealthTipsPresenter(presenter: HealthTipsPresenterImpl): HealthTipsPresenter {
        return presenter
    }

    @Provides
    fun bindPathologicalPresenter(presenter: PathologicalPresenterImpl): PathologicalPresenter {
        return presenter
    }

    @Provides
    fun bindRegisterPresenter(presenter: RegisterPresenterImpl): RegisterPresenter {
        return presenter
    }

    @Provides
    fun bindIBMPresenter(presenter: IBMPresenterImpl): IBMPresenter {
        return presenter
    }
}