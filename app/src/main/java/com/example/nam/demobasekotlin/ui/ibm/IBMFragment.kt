package com.example.nam.demobasekotlin.ui.ibm

import android.app.Dialog
import android.support.v4.internal.view.SupportMenu
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import kotlinx.android.synthetic.main.fragment_ibm.*
import javax.inject.Inject


/**
 * Created by MobileThanhNam on 4/4/2018.
 */
class IBMFragment : BaseFragment(), IBMView, View.OnClickListener {
    override fun onClick(p0: View?) {
        caculate()
        /* val pDialog = SweetAlertDialog(activity, SweetAlertDialog.PROGRESS_TYPE)
         pDialog.progressHelper.barColor = Color.parseColor("#A5DC86")
         pDialog.titleText = "Loading"
         pDialog.setCancelable(false)
         pDialog.show()*/
    }

    private fun caculate() {
        var height = edt_height.text.toString().trim()
        var weight = edt_weight.text.toString().trim()
        var sweetAlertDialog = SweetAlertDialog(activity, 1)
        sweetAlertDialog.titleText = "Oops.."
        sweetAlertDialog.confirmText = "Đóng"
        if (height.isEmpty() || weight.isEmpty()) {
            sweetAlertDialog.contentText = "Bạn phải nhập đầy đủ thông tin!"
            sweetAlertDialog.show()
        } else if (Integer.parseInt(weight) == 0) {
            sweetAlertDialog.contentText = "Cân nặng phải lớn hơn 0"
            sweetAlertDialog.show()
        } else if (Integer.parseInt(height) < 100 || Integer.parseInt(height) > 250) {
            sweetAlertDialog.contentText = "Chiều cao không được nhỏ hơn 100 (cm) và lớn hơn 250 (cm)"
            sweetAlertDialog.show()
        } else {
            val bmiround = (Math.round(10.0 * ((weight.toDouble()) / Math.pow((height.toDouble()) / 100.0, 2.0)))) / 10.0
            val weightMaxMale = ((50.0 + (0.75 * ((Integer.parseInt(height) - 150))))) + 2
            val weightMinMale = (weightMaxMale * 9) / 10
            val dialog = Dialog(activity)
            dialog.requestWindowFeature(1)
            dialog.setContentView(R.layout.dia_check_empty_tinh_bmi)
            val tvIndexBmi = dialog.findViewById<TextView>(R.id.tv_index_bmi)
            val tvHumanoid = dialog.findViewById<TextView>(R.id.tv_humanoid)
            val tvMinWeight = dialog.findViewById<TextView>(R.id.tv_min_weight)
            val tvMaxWeight = dialog.findViewById<TextView>(R.id.tv_max_weight)
            val tvTips = dialog.findViewById<TextView>(R.id.tv_tips)
            val btnCloseDialog = dialog.findViewById<Button>(R.id.btn_dia_tinhnmi_close)
            tvIndexBmi.text = bmiround.toString()
            if (bmiround in 18.5..22.9) {
                tvHumanoid.text = "Người bình thường"
            } else if (bmiround < 18.5) {
                tvHumanoid.text = "Người gầy (Thiếu cân)"
                tvIndexBmi.setTextColor(-7829368)
                tvTips.text = "Hãy ăn thật nhiều những món ăn có Protein, tinh bột, chất béo, vitamin và khoáng chất.. Ngủ đủ giấc và chọn cho mình một môn thể thao phù hợp.. Cố gắng nhé !"
            } else if (23.0 > bmiround || bmiround > 24.99) {
                tvHumanoid.text = "Người béo phì"
                tvIndexBmi.setTextColor(SupportMenu.CATEGORY_MASK)
                tvTips.text = "Bạn nên tránh những đồ ăn nhiều dầu mỡ như: Mỡ động vật, thịt mỡ. Các loại nước giải khát có ga, sữa đặc.. Nên chú ý ngủ đủ giấc, dành thời gian tập thể dục thường xuyên.. Chúc bạn thành công !"
            } else {
                tvHumanoid.text = "Người thừa cân"
                tvIndexBmi.setTextColor(SupportMenu.CATEGORY_MASK)
                tvTips.text = "Bạn nên tránh những đồ ăn nhiều dầu mỡ như: Mỡ động vật, thịt mỡ. Các loại nước giải khát có ga, sữa đặc.. Nên chú ý ngủ đủ giấc, dành thời gian tập thể dục thường xuyên.. Chúc bạn thành công !"
            }
            if (sp_gender.selectedItem == "Nam") {
                tvMinWeight.text = weightMinMale.toString()
                tvMaxWeight.text = weightMaxMale.toString()
            }
            if (sp_gender.selectedItem == "Nữ") {
                var weightMaxFemale = weightMaxMale - 2
                tvMinWeight.text = (weightMinMale - 2).toString()
                tvMaxWeight.text = (weightMaxFemale).toString()
            }
            btnCloseDialog.setOnClickListener { dialog.cancel() }
            dialog.show()
        }
    }


    @Inject
    lateinit var presenter: IBMPresenter

    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_ibm
    }

    override fun initData() {
        val genders = mutableListOf<String>()
        genders.add("Nam")
        genders.add("Nữ")

        val adapter = ArrayAdapter(activity, android.R.layout.simple_dropdown_item_1line, genders)
        sp_gender.adapter = adapter
    }

    override fun initView() {
        btn_check.setOnClickListener(this)
    }

    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
        return presenter as BasePresenter<T>
    }
}