package com.example.prayertime.fragment

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.prayertime.R
import com.example.prayertime.util.AlarmReceiver
import kotlinx.android.synthetic.main.azan_fragment.*
import java.util.*

class AzanFragment : Fragment() {

    private lateinit var viewModel: AzanViewModel
    private lateinit var option: Spinner
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.azan_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AzanViewModel::class.java)

        val options = arrayOf("Baku", "Ankara", "London", "Lankaran", "Lerik")

        activity?.let {
            option = it.findViewById(R.id.sp_option)
        }
        option.adapter = context?.let {
            ArrayAdapter(
                it.applicationContext,
                android.R.layout.simple_list_item_1,
                options
            )
        }
        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewModel.refreshData(options[p2])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                viewModel.refreshData("baku")
            }

        }

        bellsubhwhite.setOnClickListener {
            bellsubhgreen.visibility = View.VISIBLE
            bellsubhwhite.visibility = View.GONE

            val calendar: Calendar = Calendar.getInstance()
            if (Build.VERSION.SDK_INT >= 23) {
                calendar.set(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND)
                )
            } else {
                calendar.set(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND)
                )
            }
            setAlarm(calendar.timeInMillis)

            bellsubhgreen.setOnClickListener {
                bellsubhgreen.visibility = View.GONE
                bellsubhwhite.visibility = View.VISIBLE
                Toast.makeText(context, "Azan legv edildi", Toast.LENGTH_SHORT).show()
            }
        }



        bellsunwhite.setOnClickListener {
            bellsungreen.visibility = View.VISIBLE
            bellsunwhite.visibility = View.GONE
            Toast.makeText(context, "Azan quraşdırıldı", Toast.LENGTH_SHORT).show()

            val calendar: Calendar = Calendar.getInstance()
            if (Build.VERSION.SDK_INT >= 23) {
                calendar.set(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND)
                )
            } else {
                calendar.set(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND)
                )
            }
            setAlarm(calendar.timeInMillis)

            bellsungreen.setOnClickListener {
                bellsungreen.visibility = View.GONE
                bellsunwhite.visibility = View.VISIBLE
                Toast.makeText(context, "Azan legv edildi", Toast.LENGTH_SHORT).show()
            }
        }

        bellzohrwhite.setOnClickListener {
            bellzohrgreen.visibility = View.VISIBLE
            bellzohrwhite.visibility = View.GONE
            Toast.makeText(context, "Azan quraşdırıldı", Toast.LENGTH_SHORT).show()

            val calendar: Calendar = Calendar.getInstance()
            if (Build.VERSION.SDK_INT >= 23) {
                calendar.set(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND)
                )
            } else {
                calendar.set(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND)
                )
            }
            setAlarm(calendar.timeInMillis)

            bellzohrgreen.setOnClickListener {
                bellzohrgreen.visibility = View.GONE
                bellzohrwhite.visibility = View.VISIBLE
                Toast.makeText(context, "Azan legv edildi", Toast.LENGTH_SHORT).show()
            }
        }

        bellasrwhite.setOnClickListener {
            bellasrgreen.visibility = View.VISIBLE
            bellasrwhite.visibility = View.GONE
            Toast.makeText(context, "Azan quraşdırıldı", Toast.LENGTH_SHORT).show()

            val calendar: Calendar = Calendar.getInstance()
            if (Build.VERSION.SDK_INT >= 23) {
                calendar.set(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND)
                )
            } else {
                calendar.set(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND)
                )
            }
            setAlarm(calendar.timeInMillis)

            bellasrgreen.setOnClickListener {
                bellasrgreen.visibility = View.GONE
                bellasrwhite.visibility = View.VISIBLE
                Toast.makeText(context, "Azan legv edildi", Toast.LENGTH_SHORT).show()
            }
        }

        bellshamwhite.setOnClickListener {
            bellshamgreen.visibility = View.VISIBLE
            bellshamwhite.visibility = View.GONE
            Toast.makeText(context, "Azan quraşdırıldı", Toast.LENGTH_SHORT).show()

            val calendar: Calendar = Calendar.getInstance()
            if (Build.VERSION.SDK_INT >= 23) {
                calendar.set(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND)
                )
            } else {
                calendar.set(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND)
                )
            }
            setAlarm(calendar.timeInMillis)

            bellshamgreen.setOnClickListener {
                bellshamgreen.visibility = View.GONE
                bellshamwhite.visibility = View.VISIBLE
                Toast.makeText(context, "Azan legv edildi", Toast.LENGTH_SHORT).show()
            }
        }

        bellishawhite.setOnClickListener {
            bellishagreen.visibility = View.VISIBLE
            bellishawhite.visibility = View.GONE
            Toast.makeText(context, "Azan quraşdırıldı", Toast.LENGTH_SHORT).show()

            val calendar: Calendar = Calendar.getInstance()
            if (Build.VERSION.SDK_INT >= 23) {
                calendar.set(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND)
                )
            } else {
                calendar.set(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND)
                )
            }
            setAlarm(calendar.timeInMillis)

            bellishagreen.setOnClickListener {
                bellishagreen.visibility = View.GONE
                bellishawhite.visibility = View.VISIBLE
                Toast.makeText(context, "Azan ləğv edildi", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.refreshData("baku")
        idTasbeeh.setOnClickListener {
            findNavController().navigate(R.id.action_azanFragment_to_tasbeehFragment)
        }
        idCompass.setOnClickListener {
            findNavController().navigate(R.id.action_azanFragment_to_compassActivity)
        }
        idQuran.setOnClickListener {
            findNavController().navigate(R.id.action_azanFragment_to_quranFragment)
        }
        idZikr.setOnClickListener {
            findNavController().navigate(R.id.action_azanFragment_to_zikrFragment)
        }

        observeLiveData()
        createNotification()

    }

    private fun setAlarm(timeInMillis: Long) {
        val alarmManager=requireContext().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent= Intent(context, AlarmReceiver::class.java)
        val pendingIntent= PendingIntent.getBroadcast(context, 0,intent,0)
        alarmManager.setRepeating(
            AlarmManager.RTC,
            timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )
        Toast.makeText(context, "Azan quraşdırıldı", Toast.LENGTH_SHORT).show()

    }

    private fun createNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = "AzanReminder"
            val description = "Channel for alarm"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("azanandroid", name, importance)
            channel.description = description
            val notificationManager =
                requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }


    private fun observeLiveData() {
        viewModel.AzanTimeLiveData.observe(
            viewLifecycleOwner
        ) { azan ->
            azan?.let {
                teqvimGunu.text = azan.items[0].dateFor
                gunCixma.text = azan.items[0].shurooq
                subhTime.text = azan.items[0].fajr
                ZohrTime.text = azan.items[0].dhuhr
                AsrTime.text = azan.items[0].asr
                ShamTime.text = azan.items[0].maghrib
                ishaTime.text = azan.items[0].isha

            }

        }
    }
}