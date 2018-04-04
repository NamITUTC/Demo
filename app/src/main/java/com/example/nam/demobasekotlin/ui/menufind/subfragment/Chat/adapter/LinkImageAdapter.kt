package com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.example.nam.demobasekotlin.R
import kotlinx.android.synthetic.main.item_image_small.view.*

/**
 * Created by MobileThanhNam on 4/4/2018.
 */
class LinkImageAdapter(var mListImage: MutableList<String>,var mItemClick: IitemClick) : BaseAdapter() {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        var view: View
        view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_image_small, parent, false)
        Log.d("aaaaaaaLinkImage",mListImage.get(position))

        Glide.with(parent.context.applicationContext).load(mListImage.get(position)).into(view.img_image_small)
        view.setOnClickListener{
            mItemClick.iClick(mListImage.get(position))
        }
        return view
    }

    override fun getItem(position: Int): Any {
        return mListImage.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return mListImage.size
    }
}