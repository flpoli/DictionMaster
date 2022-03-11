package com.example.dictionmaster.data.remote.dto


import com.example.dictionmaster.domain.model.GrammaticalFeature
import com.google.gson.annotations.SerializedName

data class GrammaticalFeatureDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("type")
    val type: String
)

fun GrammaticalFeatureDto.toGrammaticalFeature(): GrammaticalFeature {

    return GrammaticalFeature(
        text = text,
        type = type
        )
}