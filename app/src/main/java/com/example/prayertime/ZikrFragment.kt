package com.example.prayertime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_zikr.*
import kotlinx.android.synthetic.main.row_item.*


class ZikrFragment : Fragment() {
        var zikr=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zikr, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

               zikr_artir.setOnClickListener{
                   zikr=zikr+1
                   ziktext.text= zikr.toString()
               }
        zikr_azalt.setOnClickListener{
            zikr=zikr-1
            ziktext.text= zikr.toString()
        }
        zikr_reset.setOnClickListener{
            zikr=0
            ziktext.text= zikr.toString()
        }
    }
}