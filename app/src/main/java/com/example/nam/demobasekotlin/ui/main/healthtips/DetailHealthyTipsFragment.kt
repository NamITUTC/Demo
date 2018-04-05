package com.example.nam.demobasekotlin.ui.main.healthtips

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.AsyncTask
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseSubActivity
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.common.Constant
import kotlinx.android.synthetic.main.fragment_detailhealthytips.*
import org.jsoup.Jsoup
import java.io.IOException
import javax.inject.Inject

/**
 * Created by MobileThanhNam on 4/5/2018.
 */
class DetailHealthyTipsFragment : BaseFragment(){

    @SuppressLint("StaticFieldLeak")
    private inner class GetHtmlFromUrl() : AsyncTask<Void, Void, String>() {
        internal var html: String
        internal var title: String
        val dialog = SweetAlertDialog(activity, 5)

        init {
            this.html = ""
            this.title = ""
        }

        override fun onPreExecute() {
            super.onPreExecute()

            dialog.progressHelper.barColor = Color.parseColor("#A5DC86")
            dialog.titleText = "Loading"
            dialog.setCancelable(true)
            dialog.show()
        }

        override fun doInBackground(vararg voids: Void): String {
            try {
                val document = Jsoup.connect(url).get()
                if (document != null) {
                    this.html = (document!!.select(".post-tile entry-title")).toString() + (document!!.select(".entry-content")).toString().replace("href=".toRegex(), "").replace("width=".toRegex(), "width=390px")
                } else {
                    this.html = "<p>Chưa có dữ liệu</p>"
                    this.title = "Chưa có dữ liệu"
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }

            return this.html
        }

        override fun onPostExecute(s: String) {
            super.onPostExecute(s)
            read(s)
            dialog.dismiss()
        }

        private fun read(s: String) {
            val mimeType = "text/html"
            val encoding = "UTF-8"
            wb_healthy.loadDataWithBaseURL("", "" + s + "", "text/html", "UTF-8", "")

        }
    }

    @Inject
    lateinit var presenter: DetailHealthyTipsPresenter
    lateinit var url:String
    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_detailhealthytips
    }

    override fun initData() {
        var intent: Intent = activity!!.getIntent()
        var bundle = intent.getBundleExtra(BaseSubActivity.EXTRA_FRAGMENT_ARGS)
        url = bundle.getString(Constant.LINKHEALTHYTIPS)
        GetHtmlFromUrl().execute()
    }

    override fun initView() {

    }

    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
        return presenter as BasePresenter<T>
    }
}