package com.example.prayertime.service

import com.example.prayertime.model.Salah
import io.reactivex.Single
import retrofit2.http.GET

interface AzanApi {


    @GET("{city}.json?key=5be7fe35968d5e526ae29dc0e5b1b9df")
    fun getApi(): Single<Salah>
}