package com.ngopidev.project.samplechecklistusingadapters.helpers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.ngopidev.project.samplechecklistusingadapters.R
import java.util.zip.Inflater


/**
 *   created by Irfan Assidiq on 2020-01-07
 *   email : assidiq.irfan@gmail.com
 **/
class AdapterHelpers : RecyclerView.Adapter<AdapterHelpers.HelpersViewHolder> {

    lateinit var context: Context
    lateinit var listData : ArrayList<SampleData>
    lateinit var addData : funcData
    constructor(){

    }
    constructor(context : Context, listData: ArrayList<SampleData>, addData : funcData){
        this.context = context
        this.listData = listData
        this.addData = addData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HelpersViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.forlistdata, parent, false)
        return HelpersViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: HelpersViewHolder, position: Int) {
        val data = listData.get(position)
        holder.name.text = data.nama
        if (!data.status){
            holder.img_del.visibility = View.GONE
            holder.img_add.visibility = View.VISIBLE
        }
        holder.img_add.setOnClickListener {
            addData.addData(holder, data, position)
            holder.img_del.visibility = View.VISIBLE
            holder.img_add.visibility = View.GONE
            data.status = true
            notifyDataSetChanged()
            notifyItemChanged(position)
        }
        holder.img_del.setOnClickListener {
            addData.delData(holder, data, position)
            holder.img_del.visibility = View.GONE
            holder.img_add.visibility = View.VISIBLE
            data.status = false
            notifyItemChanged(position)
        }
    }

    class HelpersViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var name : TextView
        var img_add : ImageView
        var img_del : ImageView
        init {
            name = itemView.findViewById(R.id.tv_satu)
            img_add = itemView.findViewById(R.id.img_add)
            img_del = itemView.findViewById(R.id.img_del)
        }
    }


     interface funcData{
         fun addData(viewHolder: HelpersViewHolder, sampleData: SampleData, position: Int)
         fun delData(viewHolder: HelpersViewHolder, sampleData: SampleData, position: Int)
    }


}