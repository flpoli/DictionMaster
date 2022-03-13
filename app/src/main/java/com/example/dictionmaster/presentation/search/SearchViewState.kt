package com.example.dictionmaster.presentation.search

import com.example.dictionmaster.data.remote.dto.WordInfoDto
import com.example.dictionmaster.domain.model.WordInfo

data class SearchViewState (
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)