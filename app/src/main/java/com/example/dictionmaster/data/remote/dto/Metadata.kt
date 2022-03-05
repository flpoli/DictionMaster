package com.example.dictionmaster.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Metadata(
    @SerializedName("operation")
    val operation: String,
    @SerializedName("provider")
    val provider: String,
    @SerializedName("schema")
    val schema: String
)