package com.example.prayertime.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prayertime.R
import com.example.prayertime.model.Ayah
import com.example.prayertime.model.Surah
import kotlinx.android.synthetic.main.fragment_tasbeeh.view.*
import kotlinx.android.synthetic.main.row_ayah.view.*

class AyahAdapter(val ayahList:ArrayList<Ayah>):RecyclerView.Adapter<AyahAdapter.AyahViewHolder>() {
    class AyahViewHolder(val view:View): RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyahViewHolder {
        val inflate=LayoutInflater.from(parent.context )
       val view= inflate.inflate(R.layout.row_ayah, parent, false)
        return AyahViewHolder(view)
    }

    override fun onBindViewHolder(holder: AyahViewHolder, position: Int) {
        holder.view.ayah_number.text=ayahList[position].number.toString()
        holder.view.ayah_text.text=ayahList[position].text
    }

    override fun getItemCount(): Int {
        return ayahList.size
    }

    fun updateAyahList(newAyahlist: ArrayList<Ayah>){
        ayahList.clear()
        ayahList.addAll(newAyahlist)
        notifyDataSetChanged()
    }
}