package com.example.firebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val listDetailes: ArrayList<User>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val name: TextView = itemView.findViewById(R.id.tvName)
        val mobile: TextView = itemView.findViewById(R.id.tvMobileNumber)
        val address: TextView = itemView.findViewById(R.id.tvaddress)


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.name.text = listDetailes[position].name
        holder.mobile.text = listDetailes[position].mobile
        holder.address.text = listDetailes[position].address
    }

    override fun getItemCount(): Int {
      return  listDetailes.size
    }

}