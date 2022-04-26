package com.example.prayertime.model


import com.google.gson.annotations.SerializedName

data class Quran(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("status")
    val status: String
)