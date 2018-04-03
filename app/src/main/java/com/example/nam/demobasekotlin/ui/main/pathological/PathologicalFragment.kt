package com.example.nam.demobasekotlin.ui.main.pathological

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import com.ominext.namnt.demorequestapiapplication.adapter.PathologicalAdapter
import com.ominext.namnt.demorequestapiapplication.model.Pathological
import kotlinx.android.synthetic.main.fragment_pathological.*
import javax.inject.Inject

/**
 * Created by ThanhNam on 1/29/2018.
 */
class PathologicalFragment : BaseFragment(), PathologicalView {


    @Inject
    lateinit var presenter: PathologicalPresenter
    lateinit var pathologicals: MutableList<Pathological>
    lateinit var pathologicalAdapter: PathologicalAdapter
    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_pathological
    }

    override fun initData() {
        presenter.getAllPathological()
    }

    override fun initView() {
        pathologicals = mutableListOf()
        pathologicalAdapter = PathologicalAdapter(pathologicals, mActivity)
        rc_pathological.apply {
            adapter = pathologicalAdapter
            layoutManager = LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
        return presenter as BasePresenter<T>
    }

    override fun onFail(message: String?) {
        Log.d("error", message)
    }

    override fun onSuccess(data: MutableList<Pathological>) {
        for (item in data) {
            pathologicals.add(item)
        }
        pathologicalAdapter.notifyDataSetChanged()
    }
}