package com.example.dictionmaster.domain.model

import com.example.dictionmaster.data.remote.dto.LexicalEntryDto

data class Result(
    val lexicalEntries: List<LexicalEntryDto>,
)
