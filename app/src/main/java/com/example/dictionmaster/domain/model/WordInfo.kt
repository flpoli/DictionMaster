package com.example.dictionmaster.domain.model

data class WordInfo(

    val id: String,
    val word: String,
    val results: List<Result>

)


