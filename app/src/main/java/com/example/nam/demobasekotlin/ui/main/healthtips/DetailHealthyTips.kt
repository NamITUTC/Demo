package com.example.nam.demobasekotlin.ui.main.healthtips

import android.os.AsyncTask
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import kotlinx.android.synthetic.main.fragment_detailhealthytips.*
import org.jsoup.Jsoup
import java.io.IOException

/**
 * Created by MobileThanhNam on 4/5/2018.
 */
class DetailHealthyTips : BaseFragment() {
    private inner class GetHtmlFromUrl () : AsyncTask<Void, Void, String>() {
        internal var html: String
        internal var title: String

        init {
            this.html = ""
            this.title = ""
        }

        override fun onPreExecute() {
            super.onPreExecute()
            /* HienThiBaiVietMeoVatFragment.this.pDialog = new SweetAlertDialog(HienThiBaiVietMeoVatFragment.this.getActivity(), 5);
        HienThiBaiVietMeoVatFragment.this.pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        HienThiBaiVietMeoVatFragment.this.pDialog.setTitleText("Loading");
        HienThiBaiVietMeoVatFragment.this.pDialog.setCancelable(true);
        HienThiBaiVietMeoVatFragment.this.pDialog.show();*/
        }

        override fun doInBackground(vararg voids: Void): String {
            try {
                val document = Jsoup.connect("https://ameovat.com/cach-chua-nac-voi-meo-dan-gian-cuc-nhay").get()
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

        }

        private fun read(s: String) {
            val mimeType = "text/html"
            val encoding = "UTF-8"
            wb_healthy.loadDataWithBaseURL("", "" + s + "", "text/html", "UTF-8", "")

        }
    }
    override fun injectDependence() {

    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_detailhealthytips
    }

    override fun initData() {
        GetHtmlFromUrl().execute()
    }

    override fun initView() {

    }

    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}