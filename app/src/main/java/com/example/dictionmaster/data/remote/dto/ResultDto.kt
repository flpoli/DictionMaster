package com.example.dictionmaster.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ResultDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("lexicalEntries")
    val lexicalEntries: List<LexicalEntryDto>,
    @SerializedName("type")
    val type: String,
    @SerializedName("word")
    val word: String
)