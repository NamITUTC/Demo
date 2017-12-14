package com.example.nam.demobasekotlin.ui.menu


import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseSubActivity
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.models.Data
import com.example.nam.demobasekotlin.models.Note
import com.example.nam.demobasekotlin.ui.menu.adapter.ItemAdapter
import com.example.nam.demobasekotlin.view.Canvasss
import com.example.nam.demobasekotlin.view.Constant
import com.example.nam.demobasekotlin.view.Router
import kotlinx.android.synthetic.main.fragment_menu.*
import javax.inject.Inject

/**
 * Created by nam on 11/12/2017.
 */
class MenuFragment : BaseFragment(), View.OnClickListener {

    override fun LoadData(data: List<Data>) {
        itemAdapter.datas= data as MutableList<Data>
        itemAdapter.notifyDataSetChanged()
    }


    @Inject
    lateinit var menuPresenter: MenuPresenter

    @Inject
    lateinit var mRouter: Router

    private var mItems: MutableList<Data> = mutableListOf()
    private lateinit var itemAdapter: ItemAdapter

    override fun setText(s: Int) {

    }

    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_menu
    }

    override fun initData() {

        var bundle = activity.intent.getBundleExtra(BaseSubActivity.EXTRA_FRAGMENT_ARGS)
        var hello = bundle.getString(Constant.HELLO)
        Toast.makeText(activity, hello, Toast.LENGTH_LONG).show()
    }

    override fun initView() {
        btn_open_activity.setOnClickListener {
            mRouter.goToTestActivity()
            var intent = Intent(activity, Canvasss::class.java)
            /*var bundle:Bundle= Bundle()
            bundle.putString("a","Nam")
            bundle.putString("b","Nguyen")

            intent.putExtra("bundle",bundle)
            */startActivity(intent)
        }
        btn_clear_data.setOnClickListener(this)
        btn_load_local.setOnClickListener(this)
        btn_load_server.setOnClickListener(this)
        itemAdapter = ItemAdapter(datas = mItems)
        rc_list.apply {
            adapter = itemAdapter
            layoutManager=LinearLayoutManager(activity,LinearLayout.VERTICAL,false)
        }
    }

    override fun getPresenter(): BasePresenter<BaseView>? {
        return menuPresenter
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btn_load_local -> {
            }
            R.id.btn_load_server -> {
                menuPresenter.getDataFromServer()
            }
            R.id.btn_clear_data -> {
                itemAdapter.datas= mutableListOf()
                itemAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun load(nodes: List<Note>) {

    }
}