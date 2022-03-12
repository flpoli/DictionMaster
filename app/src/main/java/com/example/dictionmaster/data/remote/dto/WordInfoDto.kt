package com.example.dictionmaster.data.remote.dto


import com.example.dictionmaster.domain.model.WordInfo
import com.google.gson.annotations.SerializedName

data class WordInfoDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("metadata")
    val metadata: Metadata,
    @SerializedName("results")
    val results: List<ResultDto>,
    @SerializedName("word")
    val word: String
)

fun WordInfoDto.toWordDefinition(): WordInfo {

    return WordInfo(
        id = id,
        word = word,
        results = results
    )
}