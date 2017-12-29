package com.example.nam.demobasekotlin.ui.menu.subfragment.chatboot.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.models.Message

/**
 * Created by nam on 29/12/2017.
 */
class ChatBootAdapter(val messageArrayList: MutableList<Message>, val ITrain: ITraining) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val SELF = 100
    private val NOT_INTENT = 99

    interface ITraining {
        fun train(mesage: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView: View

        // view type is to identify where to render the chat message
        // left or right
        if (viewType == SELF) {
            // self message
            itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.chat_item_self, parent, false)
        } else if (viewType == NOT_INTENT) {
            itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.chat_item_not_intent, parent, false)
        } else {
            // WatBot message
            itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.chat_item_watson, parent, false)
        }


        return ViewHolder(itemView)
    }

    override fun getItemViewType(position: Int): Int {
        val message = messageArrayList[position]
        if (message.id != null && message.id.equals("1")) {
            return SELF
        }
        return if (message.id != null && message.id.equals("3")) {
            NOT_INTENT
        } else position
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = messageArrayList[position]
        message.message = message.message
        (holder as ViewHolder).message.setText(message.message)
        if (getItemViewType(position) == NOT_INTENT) {
            holder.message.setOnClickListener { ITrain.train(message.message) }
        }
    }

    override fun getItemCount(): Int {
        return messageArrayList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal var message: TextView

        init {
            message = itemView.findViewById(R.id.message)
        }
    }

}