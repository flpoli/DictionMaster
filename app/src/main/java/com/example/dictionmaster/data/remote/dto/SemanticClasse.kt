package com.example.dictionmaster.data.remote.dto


import com.google.gson.annotations.SerializedName

data class SemanticClasse(
    @SerializedName("id")
    val id: String,
    @SerializedName("text")
    val text: String
)