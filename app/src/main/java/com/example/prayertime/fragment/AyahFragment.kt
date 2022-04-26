package com.example.prayertime.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prayertime.R
import com.example.prayertime.adapter.AyahAdapter
import com.example.prayertime.model.Ayah
import com.example.prayertime.model.QuranNew
import com.example.prayertime.model.Surah
import kotlinx.android.synthetic.main.ayah_fragment.*
import kotlinx.android.synthetic.main.quran_fragment.*

class AyahFragment : Fragment() {


    private lateinit var viewModel: AyahViewModel
    private val ayahAdapter=AyahAdapter(arrayListOf())
    private var ayahUuid = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.ayah_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[AyahViewModel::class.java]


        viewModel.refreshAyahData()
        rec_ayah.layoutManager=LinearLayoutManager(context)
        rec_ayah.adapter=ayahAdapter



        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.ayahLiveData.observe(viewLifecycleOwner, Observer { ayah->
            ayah?.let {
                ayahAdapter.updateAyahList(it.ayahs as ArrayList<Ayah>)
            }

        })
        viewModel.ayaLoading.observe(viewLifecycleOwner , Observer {load->
            load?.let {
                if(it){
                    ayaLoading.visibility=View.VISIBLE
                    rec_quran.visibility=View.GONE}
                else{
                    ayaLoading.visibility=View.GONE
                }
            }
        })
    }

}