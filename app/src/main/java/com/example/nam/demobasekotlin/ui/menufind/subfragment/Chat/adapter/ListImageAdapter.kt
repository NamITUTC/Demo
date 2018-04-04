package com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.nam.demobasekotlin.R
import kotlinx.android.synthetic.main.item_image.view.*

/**
 * Created by MobileThanhNam on 4/4/2018.
 */
class ListImageAdapter(var mListImage: MutableList<String>, var mContext: Context, var itemClick: IitemClick, var checkVisibleImageCheck: Boolean) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ImageViewHolder) {
            var pathImage = mListImage.get(position)
            holder.bin(pathImage, mContext, itemClick, checkVisibleImageCheck)
        }
    }

    override fun getItemCount(): Int {
        return mListImage.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_image, parent, false))
    }

    class ImageViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bin(pathImage: String, mContext: Context, itemClick: IitemClick, checkVisibleImageCheck: Boolean) {
            Glide.with(mContext).load(pathImage).into(itemView.img_image)
            itemView.setOnClickListener {
                itemClick.iClick(pathImage, itemView.img_image)
            }
            if (checkVisibleImageCheck)
                itemView.img_image.visibility = View.GONE
        }
    }
}