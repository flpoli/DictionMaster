package com.example.dictionmaster.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Synonym(
    @SerializedName("language")
    val language: String,
    @SerializedName("text")
    val text: String
)