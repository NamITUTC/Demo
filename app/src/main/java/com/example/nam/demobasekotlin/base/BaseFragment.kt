package com.example.nam.demobasekotlin.base



import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import com.example.nam.demobasekotlin.App
import com.example.nam.demobasekotlin.di.component.ActivityComponent
import com.example.nam.demobasekotlin.di.module.ActivityModule

/**
 * Created by nam on 08/12/2017.
 */
abstract class BaseFragment : Fragment(),BaseView {
    abstract fun injectDependence()
    abstract fun getLayOutRes():Int
    abstract fun initData()
    abstract fun initView()
    abstract fun<T:BaseView> getPresenter(): BasePresenter<T>?

    protected lateinit var component:ActivityComponent
    protected lateinit var mActivity:BaseActivity
    private var mPresenter: BasePresenter<BaseView>? = null
    protected lateinit var mRootView:View
    protected lateinit var unbinder:Unbinder


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity= activity as BaseActivity
        component=App.get().getComponent().plus(ActivityModule(mActivity))
        injectDependence()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mRootView= inflater!!.inflate(getLayOutRes(),container,false)
        unbinder=ButterKnife.bind(this,mRootView)
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter=getPresenter()
        mPresenter!!.onAttachView(this)

        initData()
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        unbinder.unbind()
        mPresenter!!.onDetach()
    }

    override fun addFragment(fragment: BaseFragment) {
        var frm : FragmentManager? =fragmentManager

         frm!!.beginTransaction().add(getLayOutRes(),fragment)
                .addToBackStack(fragment.javaClass.simpleName)
                .commit()
    }
}