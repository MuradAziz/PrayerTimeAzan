package com.example.prayertime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_tasbeeh.*

class TasbeehFragment : Fragment() {
    var number=0
    private var prog=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasbeeh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        button2.visibility = View.INVISIBLE
        button3.visibility = View.INVISIBLE
        button4.visibility = View.INVISIBLE
        progressBar.progress=prog

        button.setOnClickListener {
            button.visibility = View.VISIBLE
            if(prog<=90){
                prog+=1
                progressBar.progress=prog
            }
            number = number + 1
            text.text = "$number Allahu Akbar"
            if (number == 35) {
                button.visibility = View.INVISIBLE
                number = 0
                text.text = "Növbəti : Əlhəmdulillah"
                button2.visibility = View.VISIBLE
            }
        }
        button2.setOnClickListener {
            if(prog<=90){
                prog+=1
                progressBar.progress=prog
            }
            number = number + 1
            text.text = "$number  Alhamdulillah"
            if (number == 34) {
                button2.visibility = View.INVISIBLE
                number = 0
                text.text = "Növbəti : SübhanAllah"
                button3.visibility = View.VISIBLE
            }
        }
        button3.setOnClickListener {
            if(prog<=180){
                prog+=1
                progressBar.progress=prog
            }
            number = number + 1
            text.text = "$number SubhanAllah"
            if (number == 34) {
                text.text = "La ilahe Illellah \n Yenidən zikr et "
                button3.visibility = View.INVISIBLE
                button4.visibility = View.VISIBLE
            }
            button4.setOnClickListener {
                prog=0
                if(prog<=90){
                    prog+=1
                    progressBar.progress=prog
                }
                button4.visibility=View.INVISIBLE
                number=0
                button.visibility=View.VISIBLE
                number = number + 1
                text.text = "$number Allahu Akbar"
            }
        }
        btnreset.setOnClickListener {
            prog=0
            progressBar.progress=prog
            button4.visibility=View.INVISIBLE
            button2.visibility=View.INVISIBLE
            button3.visibility=View.INVISIBLE
            number=0
            button.visibility=View.VISIBLE
            text.text = "$number Allahu Akbar"
        }
    }
}