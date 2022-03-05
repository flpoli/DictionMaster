package com.example.dictionmaster.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ThesaurusLink(
    @SerializedName("entry_id")
    val entryId: String,
    @SerializedName("sense_id")
    val senseId: String
)