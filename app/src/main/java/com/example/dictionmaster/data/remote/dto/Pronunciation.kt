package com.example.dictionmaster.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Pronunciation(
    @SerializedName("audioFile")
    val audioFile: String,
    @SerializedName("dialects")
    val dialects: List<String>,
    @SerializedName("phoneticNotation")
    val phoneticNotation: String,
    @SerializedName("phoneticSpelling")
    val phoneticSpelling: String
)