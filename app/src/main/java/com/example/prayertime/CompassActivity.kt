package com.example.prayertime

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import kotlinx.android.synthetic.main.activity_compass.*


class CompassActivity : AppCompatActivity(), SensorEventListener {

    private var currentDegree=0f
    private var sensorManager: SensorManager?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compass)
        initData()

    }

    private fun initData() {
        sensorManager=getSystemService(Context.SENSOR_SERVICE) as SensorManager?
    }

    override fun onResume() {
        super.onResume()
        @Suppress("DEPRECATION")
        sensorManager?.registerListener(this,
            sensorManager?.getDefaultSensor(Sensor.TYPE_ORIENTATION),
            SensorManager.SENSOR_DELAY_GAME
        )
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        val degree=Math.round(p0?.values?.get(0)!!)

        val rotationAnimation= RotateAnimation(
            currentDegree, (-degree).toFloat(),
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotationAnimation.duration=210
        rotationAnimation.fillAfter=true
        imgcompas.startAnimation(rotationAnimation)
        currentDegree=(-degree).toFloat()
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}