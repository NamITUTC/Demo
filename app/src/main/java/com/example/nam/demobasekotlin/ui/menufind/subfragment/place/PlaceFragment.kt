package com.example.nam.demobasekotlin.ui.menufind.subfragment.place

import android.app.ProgressDialog
import android.graphics.Color
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.nam.demobasekotlin.App
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.common.Router
import com.example.nam.demobasekotlin.models.map.Derection
import com.example.nam.demobasekotlin.models.map.Example
import com.example.nam.demobasekotlin.models.map.Place
import com.example.nam.demobasekotlin.ui.main.adapter.IClick
import kotlinx.android.synthetic.main.fragment_view.*
import javax.inject.Inject

/**
 * Created by nam on 20/12/2017.
 */
class PlaceFragment : BaseFragment(), IClick, PlaceView {
    override fun itemClick(position: Int, link: String) {

    }


    @Inject
    lateinit var router: Router
    @Inject
    lateinit var presenter: PlacePresenter
    lateinit var placeAdapter: PlaceAdapter
    lateinit var places1: MutableList<Place>
    lateinit var places2: MutableList<Place>
    lateinit var places: MutableList<Place>
    lateinit var tempLocation: MutableList<String>
    lateinit var dialog: SweetAlertDialog
    var d = 0
    var count = 0
    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_view
    }

    override fun initData() {
        places = mutableListOf()
        places1 = mutableListOf()
        places2 = mutableListOf()
        tempLocation = mutableListOf()
        dialog = SweetAlertDialog(activity, 5)
        dialog.progressHelper.barColor = Color.parseColor("#A5DC86")
        dialog.titleText = "Loading"
        dialog.setCancelable(true)
        dialog.show()
        presenter.getAllPlace(App.get().currentPosition)
    }

    override fun initView() {
        /* p=ProgressDialog(activity!!)
         var handler = Handler()
         handler.postDelayed({

             p.show()
         },2000)*/

        placeAdapter = PlaceAdapter(places, activity!!, this)
        rc_places.apply {
            adapter = placeAdapter
            layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
        return presenter as BasePresenter<T>
    }

    override fun onFail(message: String?) {
        Log.d("onFail", message)
    }

    override fun OnSuccess(route: Derection) {

        for (i in 0 until route!!.routes!!.get(0).legs!!.size) {
            val leg = route!!.routes!!.get(0).legs!!.get(i)
            places2.add(Place("", "", "", 0f, leg.distance!!.text, leg.duration!!.text!!, ""))
        }
        if (places2.size == count) {
            d++
            for (i in 0 until count) {
                places.add(Place(places1[i].image, places1[i].name, places1[i].address,
                        places1[i].rate, places2[i].distance, places2[i].time, places2[i].poliline))
                placeAdapter.notifyDataSetChanged()
            }
            dialog.dismiss()
        }
        /*if(d==count){
            p.dismiss()
        }*/

        //    ToastUltil.show(activity!!,"ok")
    }

    override fun itemClick(postion: Int) {
        router.goToChat()
    }

    override fun getAllPlaceSuccess(result: Example) {

        for (i in 0 until result.results!!.size) {
            val endLocation = "${result.results[i].geometry!!.location!!.lat},${result.results[i].geometry!!.location!!.lng}"
            tempLocation.add(endLocation)
            var s = ""
            var rate: Float = 0f
            var name = ""
            var address = ""
            if (result.results[i].photos != null) {
                if (result.results[i].photos!![0].photoReference != null) {
                    s = result.results[i].photos?.get(0)?.photoReference!!
                }
            }
            if (result.results[i].rating != null) {
                rate = result.results[i].rating!!.toFloat()
            }
            if (result.results[i].name != null) {
                name = result.results[i].name!!
            }
            if (result.results[i].vicinity != null) {
                address = result.results[i].vicinity!!
            }
            val place = Place(s, name, address, rate, "", "", "")
            places1.add(place)
            count++

        }
        Log.d("count", count.toString())
        if (tempLocation.size == result.results.size) {
            for (endLocation in tempLocation)
                presenter.getDistance(App.get().currentPosition, endLocation)
        }
    }
}