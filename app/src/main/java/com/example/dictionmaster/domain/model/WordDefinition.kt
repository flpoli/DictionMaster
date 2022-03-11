package com.example.dictionmaster.domain.model

import com.example.dictionmaster.data.remote.dto.ResultDto

data class WordDefinition(

    val id: String,
    val word: String,
    val results: List<ResultDto>

)
