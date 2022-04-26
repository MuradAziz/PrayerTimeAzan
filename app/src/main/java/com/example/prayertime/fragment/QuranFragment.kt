package com.example.prayertime.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prayertime.R
import com.example.prayertime.adapter.AdapterQuran
import kotlinx.android.synthetic.main.quran_fragment.*

class QuranFragment : Fragment() {
    private val quranAdapter=AdapterQuran(arrayListOf()){
        findNavController().navigate(R.id.action_quranFragment_to_ayahFragment)
    }

    private lateinit var viewModel: QuranViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.quran_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(QuranViewModel::class.java)

        viewModel.refreshDataQuran()

        rec_quran.layoutManager=LinearLayoutManager(context)
        rec_quran.adapter=quranAdapter

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.quranLiveData.observe(viewLifecycleOwner, Observer { quran->
            quran?.let {
                quranAdapter.updateQuranList(quran.data.surahs)
            }
        })
        viewModel.quranLoading.observe(viewLifecycleOwner, Observer { load->
            load?.let {
                if (it) {
                    quranLoading.visibility = View.VISIBLE
                    rec_quran.visibility = View.GONE
                } else {
                    quranLoading.visibility = View.GONE
                }

            }
        })

    }

}