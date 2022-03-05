package com.example.dictionmaster.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Derivative(
    @SerializedName("id")
    val id: String,
    @SerializedName("text")
    val text: String
)