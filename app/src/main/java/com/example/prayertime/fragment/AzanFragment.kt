package com.example.prayertime.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.prayertime.R
import kotlinx.android.synthetic.main.azan_fragment.*

class AzanFragment : Fragment() {

    private lateinit var viewModel: AzanViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.azan_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AzanViewModel::class.java)

        viewModel.refreshData()
        idTasbeeh.setOnClickListener{
        findNavController().navigate(R.id.action_azanFragment_to_tasbeehFragment)
        }
        idCompass.setOnClickListener{
            findNavController().navigate(R.id.action_azanFragment_to_compassActivity)
        }

        observeLiveData()

    }

    private fun observeLiveData() {
        viewModel.AzanTimeLiveData.observe(viewLifecycleOwner, { azan ->
            azan?.let {
                subhTime.text = azan.items[0].fajr
                ZohrTime.text = azan.items[0].dhuhr
                AsrTime.text = azan.items[0].asr
                ShamTime.text = azan.items[0].maghrib
                ishaTime.text = azan.items[0].isha
            }

        }
        )
    }
}