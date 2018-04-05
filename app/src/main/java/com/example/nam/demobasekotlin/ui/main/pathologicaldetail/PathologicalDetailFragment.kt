package com.example.nam.demobasekotlin.ui.main.pathologicaldetail

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.Util.ToastUltil
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseSubActivity
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.common.Constant
import com.example.nam.demobasekotlin.common.Router
import com.example.nam.demobasekotlin.ui.main.adapter.IClick
import com.ominext.namnt.demorequestapiapplication.adapter.PathologicalAdapter
import com.ominext.namnt.demorequestapiapplication.model.Pathological
import kotlinx.android.synthetic.main.fragment_pathological.*
import javax.inject.Inject

/**
 * Created by MobileThanhNam on 4/5/2018.
 */
class PathologicalDetailFragment : BaseFragment(), PathologicalDetailView, IClick {
    override fun itemClick(postion: Int) {

    }

    override fun itemClick(position: Int, link: String) {
        router.goToPathologicalInfor(link)
    }

    @Inject
    lateinit var router: Router
    @Inject
    lateinit var presenter: PathologicalDetailPresenter
    lateinit var pathologicals: MutableList<Pathological>
    lateinit var pathologicalAdapter: PathologicalAdapter
    lateinit var url: String
    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_pathological
    }

    override fun initData() {
        var intent: Intent = activity!!.getIntent()
        var bundle = intent.getBundleExtra(BaseSubActivity.EXTRA_FRAGMENT_ARGS)
        url = bundle.getString(Constant.LINKDETAILPATHOLOGICAL)
        presenter.getAllPathological(url)
    }

    override fun initView() {
        pathologicals = mutableListOf()
        pathologicalAdapter = PathologicalAdapter(pathologicals, mActivity, this)
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