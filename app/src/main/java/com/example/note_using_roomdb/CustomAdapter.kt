package com.example.note_using_roomdb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.note_using_roomdb.models.NoteModel

class CustomAdapter(private val dataList: ArrayList<NoteModel>):RecyclerView.Adapter<CustomAdapter.CustomViewHolder>(){
    class CustomViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.sample_title)
        val description: TextView = itemView.findViewById(R.id.sample_description)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.custom_layout, parent, false)
        return CustomViewHolder(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.title.text = dataList[position].title
        holder.description.text = dataList[position].description
    }

}