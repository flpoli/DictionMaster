package com.example.dictionmaster.domain.model

import androidx.room.TypeConverters
import com.example.dictionmaster.data.local.Converters
import com.example.dictionmaster.data.remote.dto.LexicalEntryDto

data class Result(
    val lexicalEntries: List<LexicalEntry>

)
