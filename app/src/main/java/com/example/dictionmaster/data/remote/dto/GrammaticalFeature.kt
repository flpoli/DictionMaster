package com.example.dictionmaster.data.remote.dto


import com.google.gson.annotations.SerializedName

data class GrammaticalFeature(
    @SerializedName("id")
    val id: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("type")
    val type: String
)