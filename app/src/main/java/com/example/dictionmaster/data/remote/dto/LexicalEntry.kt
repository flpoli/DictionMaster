package com.example.dictionmaster.data.remote.dto


import com.google.gson.annotations.SerializedName

data class LexicalEntry(
    @SerializedName("derivatives")
    val derivatives: List<Derivative>,
    @SerializedName("entries")
    val entries: List<Entry>,
    @SerializedName("language")
    val language: String,
    @SerializedName("lexicalCategory")
    val lexicalCategory: LexicalCategory,
    @SerializedName("text")
    val text: String
)