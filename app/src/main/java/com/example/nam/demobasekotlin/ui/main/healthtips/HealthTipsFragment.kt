package com.example.nam.demobasekotlin.ui.main.healthtips

import android.support.v7.widget.LinearLayoutManager
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import com.ominext.namnt.demorequestapiapplication.adapter.HealthTipAdapter
import com.ominext.namnt.demorequestapiapplication.model.HealthTip
import kotlinx.android.synthetic.main.fragment_healthtips.*
import javax.inject.Inject

/**
 * Created by ThanhNam on 1/29/2018.
 */
class HealthTipsFragment : BaseFragment(), HealthTipAdapter.IClick, HealthTipsView {


    @Inject
    lateinit var presenter: HealthTipsPresenter
    lateinit var healthTipsAdapter: HealthTipAdapter
    lateinit var healthTips: MutableList<HealthTip>

    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_healthtips
    }

    override fun initData() {
        presenter.getAllHealthTips()


    }

    override fun initView() {
        healthTips = mutableListOf()
        healthTipsAdapter = HealthTipAdapter(healthTips, this, mActivity)
        rc_tips.apply {
            adapter = healthTipsAdapter
            layoutManager = LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
        return presenter as BasePresenter<T>
    }
    override fun onSuccess(data: MutableList<HealthTip>) {
        for(i in data){
            healthTips.add(i)
        }
        healthTipsAdapter.notifyDataSetChanged()
    }

    override fun onFail(toString: String) {

    }

    override fun itemClick(position: Int, link: String) {

    }
}