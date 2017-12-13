package com.example.nam.demobasekotlin.ui.login.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.models.Note
import kotlinx.android.synthetic.main.item_note.view.*

/**
 * Created by nam on 13/12/2017.
 */
class NoteAdapter(var notes: List<Note>,var iClick: IClick) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface IClick {
        fun click(note:Note)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val note=notes.get(position)
        if(holder is NoteHolder){
            holder.bindNote(note,iClick)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return NoteHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_note,parent,false))
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    class NoteHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){
        fun bindNote(note: Note, iClick: IClick) {
            itemView.txt_title.text=note.title
            itemView.txt_content.text=note.content
            itemView.txt_id.text=note.id.toString()
            itemView.setOnClickListener { iClick.click(note) }
        }

    }
}