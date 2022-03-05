package com.example.dictionmaster.data.remote.dto


import com.google.gson.annotations.SerializedName

data class SynonymX(
    @SerializedName("language")
    val language: String,
    @SerializedName("text")
    val text: String
)