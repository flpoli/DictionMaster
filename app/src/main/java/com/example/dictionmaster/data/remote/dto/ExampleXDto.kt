package com.example.dictionmaster.data.remote.dto


import com.example.dictionmaster.domain.model.ExampleX
import com.google.gson.annotations.SerializedName

data class ExampleXDto(
    @SerializedName("text")
    val text: String
)

fun ExampleXDto.toExampleX(): ExampleX {

    return ExampleX(
        text = text
    )
}