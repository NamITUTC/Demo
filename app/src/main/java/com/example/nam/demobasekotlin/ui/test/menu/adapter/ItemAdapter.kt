package com.example.nam.demobasekotlin.ui.test.menu.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.models.Data
import kotlinx.android.synthetic.main.item_data.view.*

/**
* Created by nam on 14/12/2017.
*/
class ItemAdapter(var datas: List<Data>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val data = datas[position]
        if (holder is DataViewHolder) {
            holder.bin(data = data)
        }
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return DataViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_data, parent, false))
    }

    class DataViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bin(data: Data) {
            itemView.txt_name.text = data.quotaMax.toString()
        }
    }

}