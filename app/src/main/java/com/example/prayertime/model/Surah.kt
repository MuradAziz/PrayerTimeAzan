package com.example.prayertime.model


import com.google.gson.annotations.SerializedName

data class Surah(
    @SerializedName("ayahs")
    val ayahs: List<Ayah>,
    @SerializedName("englishName")
    val englishName: String,
    @SerializedName("englishNameTranslation")
    val englishNameTranslation: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("number")
    val number: Int,
    @SerializedName("revelationType")
    val revelationType: String
)