package com.example.prayertime.service

import com.example.prayertime.model.Salah
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AzanApiService {
    private val base_url="https://muslimsalat.com/"
    private val api= Retrofit.Builder()
        .baseUrl(base_url)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AzanApi::class.java)

    fun getData(city: String): Single<Salah>{
        return api.getApi(city)
    }

}
