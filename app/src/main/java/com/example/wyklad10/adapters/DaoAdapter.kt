package com.example.wyklad10.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wyklad10.R
import com.example.wyklad10.room.Sklep


class DaoAdapter(private val listOfSklepy: List<Sklep>): RecyclerView.Adapter<DaoAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val row = layoutInflater.inflate(R.layout.sklep_cardview,parent, false)
        return MyViewHolder(row)
    }

    override fun getItemCount(): Int {
        return listOfSklepy.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nazwaTextView.text = listOfSklepy[position].nazwa
        holder.opisTextView.text = listOfSklepy[position].opis
        holder.promienTextView.text = listOfSklepy[position].promien

    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nazwaTextView: TextView = view.findViewById(R.id.nazwaTV)
        val opisTextView: TextView = view.findViewById(R.id.opisTV)
        val promienTextView: TextView = view.findViewById(R.id.promienTV)

    }

}