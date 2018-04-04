package com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.nam.demobasekotlin.R
import kotlinx.android.synthetic.main.item_image.view.*

/**
 * Created by MobileThanhNam on 4/4/2018.
 */
class ImageAdapter(var mListImage: MutableList<String>, var mContext: Context, var itemClick: IitemClick) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface IitemClick {
        fun iClick(pathImage: String, img_image: ImageView?)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ImageViewHolder) {
            var pathImage = mListImage.get(position)
            holder.bin(pathImage, mContext, itemClick)
        }
    }

    override fun getItemCount(): Int {

        return mListImage.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_image, parent, false))
    }

    class ImageViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bin(pathImage: String, mContext: Context, itemClick: IitemClick) {
            Glide.with(mContext).load(pathImage).into(itemView.img_image)
            itemView.setOnClickListener {
                itemClick.iClick(pathImage, itemView.img_image)
            }
        }
    }
}