package com.ominext.namnt.demorequestapiapplication.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseActivity
import com.ominext.namnt.demorequestapiapplication.model.Pathological
import kotlinx.android.synthetic.main.item_tip.view.*


/**
 * Created by nam on 02/02/2018.
 */
class PathologicalAdapter(var pathologicals: MutableList<Pathological>, mActivity: BaseActivity) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return pathologicals.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PathologicalviewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_tip, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PathologicalviewHolder) {
            holder.bind(pathologicals[position])
        }
    }

    class PathologicalviewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(pathological: Pathological) {
            //itemView.txt_id_tip.text = pathological.id.toString()
            itemView.txt_title_tip.text = pathological.title.toString()
            itemView.txt_content_tip.text = pathological.detail.toString()

        }
    }
}