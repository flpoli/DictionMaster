package com.example.dictionmaster.data.remote.dto


import com.example.dictionmaster.data.local.entity.WordInfoEntity
import com.example.dictionmaster.domain.model.WordInfo
import com.google.gson.annotations.SerializedName

data class WordInfoDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("metadata")
    val metadata: Metadata,
    @SerializedName("results")
    var results: ArrayList<ResultDto> = arrayListOf(),
    @SerializedName("word")
    val word: String,

)

fun WordInfoDto.toWordInfo(): WordInfo {

    return WordInfo(
        id = id,
        word = word,
        results = results.map { it.toResult() },
    )
}