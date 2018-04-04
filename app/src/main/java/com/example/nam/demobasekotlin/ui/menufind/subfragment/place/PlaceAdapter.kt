package com.example.nam.demobasekotlin.ui.menufind.subfragment.place

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.models.map.Place
import com.example.nam.demobasekotlin.ui.main.adapter.IClick
import kotlinx.android.synthetic.main.fragment_map.*
import kotlinx.android.synthetic.main.item_place.view.*

/**
 * Created by ThanhNam on 2/4/2018.
 */
class PlaceAdapter(var places: List<Place>, var context: Context, var iClick: IClick) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PlaceViewHolder(LayoutInflater.from(context).inflate(R.layout.item_place, parent, false))
    }

    override fun getItemCount(): Int {
        return places.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PlaceViewHolder) {
            holder.bind(places.get(position), context)
            holder.itemView.setOnClickListener {
                iClick.itemClick(position)
            }
        }
    }

    class PlaceViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(place: Place, context: Context) {
            itemView.txt_adress.text = place.address
            itemView.txt_distance.text = place.distance
            itemView.txt_time.text = place.time
            itemView.txt_name_clinic.text = place.name
            itemView.rt_rate.rating = place.rate!!
            val link = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=${place.image}&key=AIzaSyAjCxDFbqC9uy11X5SKpmLzVqFXy6KKJP4"
            Glide.with(context).load(link).into(itemView.img_ava)
        }
    }
}