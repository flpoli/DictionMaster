package com.example.dictionmaster.presentation.search

import com.example.dictionmaster.data.remote.dto.WordInfoDto

data class SearchViewState (
    val wordInfoItems: WordInfoDto? = null,
    val isLoading: Boolean = false
)