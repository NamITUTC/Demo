package com.example.nam.demobasekotlin.ui.menu


import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.ui.menu.subfragment.Chat.ChatFragment
import com.example.nam.demobasekotlin.ui.menu.subfragment.chatboot.ChatBootFragment
import com.example.nam.demobasekotlin.ui.menu.subfragment.search.SearchFragment
import com.example.nam.demobasekotlin.ui.menu.subfragment.view.ViewFragment
import kotlinx.android.synthetic.main.fragment_menu.*
import javax.inject.Inject

/**
* Created by nam on 20/12/2017.
*/
class MenuFragment : BaseFragment(), BottomNavigationView.OnNavigationItemSelectedListener {
    @Inject
    lateinit var presenter: MenuPresenter
    override fun injectDependence() {

        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_menu
    }

    override fun initData() {

    }

    override fun initView() {
//        adapter=MenuAdapter(fragmentManager)
        bottom_navigation.setOnNavigationItemSelectedListener(this)
    }

    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
        return presenter as BasePresenter<T>
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mnu_chat ->
                loadFragment(ChatFragment())
            R.id.mnu_search -> loadFragment(SearchFragment())
            R.id.mnu_view -> loadFragment(ViewFragment())
            R.id.mnu_chat_boot -> loadFragment(ChatBootFragment())
        }
        loadFragment(ChatBootFragment())
        return true
    }

    private fun loadFragment(fragment: BaseFragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container_menu, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}