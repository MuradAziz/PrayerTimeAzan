package com.example.prayertime.model


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("edition")
    val edition: Edition,
    @SerializedName("surahs")
    val surahs: List<Surah>
)