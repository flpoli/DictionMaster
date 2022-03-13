package com.example.dictionmaster.domain.model

import androidx.room.Embedded
import androidx.room.TypeConverters
import com.example.dictionmaster.data.local.Converters

data class WordInfo(

    //val id: Int? = null,
    val word: String = "",
    val results: List<Result> = emptyList()

)


