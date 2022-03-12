package com.example.dictionmaster.domain.model

import com.example.dictionmaster.data.remote.dto.ResultDto

data class WordInfo(

    val id: String,
    val word: String,
    val results: List<ResultDto>

)
