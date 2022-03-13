package com.example.dictionmaster.data.remote.dto


import com.example.dictionmaster.data.local.entity.WordInfoEntity
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

fun WordInfoDto.toWordInfoEntity(): WordInfoEntity {

    return WordInfoEntity(
        word = word,
        results = results.map { it.toResult() },
    )
}