package com.example.dictionmaster.data.remote.dto


import com.example.dictionmaster.domain.model.Entry
import com.google.gson.annotations.SerializedName

data class EntryDto(
    @SerializedName("etymologies")
    val etymologies: List<String>,
    @SerializedName("grammaticalFeatures")
    val grammaticalFeatures: List<GrammaticalFeatureDto>,
    @SerializedName("pronunciations")
    val pronunciations: List<PronunciationDto>,
    @SerializedName("senses")
    val senses: List<SenseDto>
)

fun EntryDto.toEntry(): Entry {

    return Entry(
        grammaticalFeatures = grammaticalFeatures.map { it.toGrammaticalFeature() },
        pronunciations = pronunciations.map { it.toPronunciation()},
        senses = senses.map { it.toSense() }
    )

}