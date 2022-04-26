package com.example.prayertime.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.prayertime.R
import com.example.prayertime.model.Data
import com.example.prayertime.model.Surah
import kotlinx.android.synthetic.main.fragment_tasbeeh.view.*
import kotlinx.android.synthetic.main.row_item.view.*
import java.util.zip.Inflater

class AdapterQuran (val quranList:ArrayList<Surah>,
                    private val onClick:(item:Surah)->Unit):
    RecyclerView.Adapter<AdapterQuran.QuranViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranViewHolder {
        val inflate=LayoutInflater.from(parent.context)
       val view= inflate.inflate(R.layout.row_item, parent, false)
        return QuranViewHolder(view)
    }


    override fun onBindViewHolder(holder: QuranViewHolder, position: Int) {
       holder.bindWith(quranList[position], onClick)
    }
    class QuranViewHolder(val view: View): RecyclerView.ViewHolder(view){
        fun bindWith(surahDto:Surah, onClick: (item: Surah) -> Unit){
            itemView.findViewById<TextView>(R.id.english_name).text=surahDto.englishName
            itemView.findViewById<TextView>(R.id.total_ayah).text=surahDto.revelationType
            itemView.findViewById<TextView>(R.id.number).text=surahDto.number.toString()
            itemView.findViewById<TextView>(R.id.arabic_name).text=surahDto.name
            itemView.setOnClickListener {
                onClick.invoke(surahDto)
            }
        }
    }

    override fun getItemCount(): Int {
        return quranList.size
    }

    fun updateQuranList(newQuranlist: List<Surah>){
        quranList.clear()
        quranList.addAll(newQuranlist)
        notifyDataSetChanged()
    }
}




