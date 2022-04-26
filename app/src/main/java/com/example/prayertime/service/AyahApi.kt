package com.example.prayertime.service

import com.example.prayertime.model.*
import io.reactivex.Single
import retrofit2.http.GET

interface AyahApi {

    @GET("v1/quran/en.asad")
    fun getAyahApi(): Single<Surah>
}