package com.example.nam.demobasekotlin.ui.main.healthtips

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.Util.ToastUltil
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.common.Router
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
    @Inject
    lateinit var router: Router
    lateinit var healthTipsAdapter: HealthTipAdapter
    lateinit var healthTips: MutableList<HealthTip>
    lateinit var dialog: SweetAlertDialog

    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_healthtips
    }

    override fun initData() {
        dialog = SweetAlertDialog(activity, 5)
        presenter.getAllHealthTips()

        dialog.progressHelper.barColor = Color.parseColor("#A5DC86")
        dialog.titleText = "Loading"
        dialog.setCancelable(true)
        dialog.show()

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
        for (i in data) {
            healthTips.add(i)
        }
        healthTipsAdapter.notifyDataSetChanged()
        dialog.dismiss()
    }

    override fun onFail(error: String) {
        ToastUltil.show(this.activity!!, error)
    }

    override fun itemClick(position: Int, link: String) {
        router.goToDetailHealthyTips(link)
    }
}