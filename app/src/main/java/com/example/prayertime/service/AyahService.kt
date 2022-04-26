package com.example.prayertime.service

import com.example.prayertime.model.*
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AyahService {

    private val base_url="https://api.alquran.cloud/"
    private val api= Retrofit.Builder()
        .baseUrl(base_url)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(AyahApi::class.java)

    fun getAyahData(): Single<Surah>{
       return api.getAyahApi()
    }
}