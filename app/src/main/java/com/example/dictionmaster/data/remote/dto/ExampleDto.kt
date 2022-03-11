package com.example.dictionmaster.data.remote.dto


import com.example.dictionmaster.domain.model.Example
import com.google.gson.annotations.SerializedName

data class ExampleDto(
    @SerializedName("text")
    val text: String
)

fun ExampleDto.toExample(): Example {

    return Example(
        text = text
    )
}