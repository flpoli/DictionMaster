package com.example.dictionmaster.data.remote.dto


import com.example.dictionmaster.domain.model.WordDefinition
import com.google.gson.annotations.SerializedName

data class WordDefinitionDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("metadata")
    val metadata: Metadata,
    @SerializedName("results")
    val results: List<ResultDto>,
    @SerializedName("word")
    val word: String
)

fun WordDefinitionDto.toWordDefinition(): WordDefinition {

    return WordDefinition(
        id = id,
        word = word,
        results = results
    )
}