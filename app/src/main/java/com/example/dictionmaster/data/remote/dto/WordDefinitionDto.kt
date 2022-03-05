package com.example.dictionmaster.data.remote.dto


import com.google.gson.annotations.SerializedName

data class WordDefinitionDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("metadata")
    val metadata: Metadata,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("word")
    val word: String
)