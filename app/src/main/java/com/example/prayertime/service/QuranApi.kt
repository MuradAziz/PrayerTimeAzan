package com.example.prayertime.service

import com.example.prayertime.model.Quran
import com.example.prayertime.model.QuranNew
import io.reactivex.Single
import retrofit2.http.GET

interface QuranApi {

    @GET("v1/quran/en.asad")
    fun getQuranApi(): Single<QuranNew>
}