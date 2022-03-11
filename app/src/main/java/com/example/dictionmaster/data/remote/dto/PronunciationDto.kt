package com.example.dictionmaster.data.remote.dto


import com.example.dictionmaster.domain.model.Pronunciation
import com.google.gson.annotations.SerializedName

data class PronunciationDto(
    @SerializedName("audioFile")
    val audioFile: String,
    @SerializedName("dialects")
    val dialects: List<String>,
    @SerializedName("phoneticNotation")
    val phoneticNotation: String,
    @SerializedName("phoneticSpelling")
    val phoneticSpelling: String
)

fun PronunciationDto.toPronunciation(): Pronunciation {

    return Pronunciation(

        audioFile = audioFile,
        phoneticNotation = phoneticNotation,
        phoneticSpelling = phoneticSpelling

    )

}