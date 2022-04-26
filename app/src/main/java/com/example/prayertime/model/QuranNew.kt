package com.example.prayertime.model


import com.google.gson.annotations.SerializedName

data class QuranNew(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: DataX,
    @SerializedName("status")
    val status: String
)